package com.flydance.tutu.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.flydance.basemodule.base.AbsActivity;
import com.flydance.tutu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;


/**
 * Created by tutu on 16/4/10.
 */
public abstract class BaseActivity extends AbsActivity {

    //private Unbinder unbinder;

    public abstract int getLayoutID();

    public abstract void initView();

    public abstract void initData();

    protected Context mBaseActivityContext;
    protected Context mApplicationContext;
    public SVProgressHUD svProgressHUD;
    protected List<Subscription> subscriptions;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(
                    R.color.colorPrimary));
        }

        setContentView(getLayoutID());
        //unbinder = ButterKnife.bind(this);
        ButterKnife.bind(this);
        subscriptions = new ArrayList<>();
        svProgressHUD = new SVProgressHUD(this);
        mBaseActivityContext = this;
        mApplicationContext = getApplicationContext();
        initView();
        initData();
    }

    public SVProgressHUD getSVProgressHUD() {
        return svProgressHUD;
    }

    @Nullable
    @OnClick(R.id.base_layout)
    public void onBaseClick(View view) {
        hideKeyBoard();
    }

    public void showLoadingDialog(String msg) {
        svProgressHUD.showWithStatus(msg, SVProgressHUD.SVProgressHUDMaskType.None);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }





    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        hideKeyBoard();
        super.onDestroy();
//        unbinder.unbind();
        ButterKnife.unbind(this);
        for (Subscription subscription : subscriptions) {
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }


    protected void showLoadingDialog(Context context) {

    }

    protected void cancelLoadingDialog() {

    }

}
