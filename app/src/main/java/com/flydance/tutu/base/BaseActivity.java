package com.flydance.tutu.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.flydance.basemodule.base.AbsActivity;
import com.flydance.tutu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;


/**
 * Created by tutu on 16/4/10.
 */
public abstract class BaseActivity extends AbsActivity {

	public abstract int getLayoutID();

	public abstract void initTitle(TextView titleName, View ivBack, View ivMenu, View titleRoot);

	public abstract void initView();

	public abstract void initData();

	protected Context mBaseActivityContext;
	protected Context mApplicationContext;
	public SVProgressHUD svProgressHUD;
	protected List<Subscription> subscriptions;

	@Bind(R.id.tv_titel)
	TextView titleName;
	@Bind(R.id.iv_back)
	View ivBack;
	@Bind(R.id.iv_menu)
	View ivMenu;
	@Bind(R.id.title_root)
	View titleRoot;


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
		ButterKnife.bind(this);
		subscriptions = new ArrayList<>();
		svProgressHUD = new SVProgressHUD(this);
		mBaseActivityContext = this;
		mApplicationContext = getApplicationContext();
		initView();
		initData();
	}

	@Override
	protected void onStart() {
		super.onStart();
		initTitle(titleName, ivBack, ivMenu, titleRoot);
	}

	public SVProgressHUD getSVProgressHUD() {
		return svProgressHUD;
	}

	@Nullable
	@OnClick({R.id.base_layout, R.id.iv_back})
	public void onBaseClick(View view) {
		switch (view.getId()) {
			case R.id.base_layout:
				hideKeyBoard();
				break;
			case R.id.iv_back:
				finish();
				break;
		}
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


	protected void addSubscription(Subscription subscription) {
		subscriptions.add(subscription);
	}


	@Override
	protected void onDestroy() {
		hideKeyBoard();
		super.onDestroy();
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
