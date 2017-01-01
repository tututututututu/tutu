package com.flydance.tutu.regist;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flydance.basemodule.base.ActivityStack;
import com.flydance.basemodule.utils.ResourceUtils;
import com.flydance.tutu.AppUI.Toast;
import com.flydance.tutu.R;
import com.flydance.tutu.app.Constant;
import com.flydance.tutu.base.BaseActivity;
import com.flydance.tutu.main.MainActivity;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.functions.Action1;

public class RegistActivity extends BaseActivity implements RegistContract.View {


	RegistContract.Presenter presenter;
	@Bind(R.id.et_username)
	EditText etUsername;
	@Bind(R.id.et_psw)
	EditText etPsw;
	@Bind(R.id.btn_regist)
	Button btnRegist;
	@Bind(R.id.activity_regist)
	LinearLayout activityRegist;

	@Override
	public int getLayoutID() {
		return R.layout.activity_regist;
	}

	@Override
	public void initTitle(TextView titleName, View ivBack, View ivMenu, View titleRoot) {
		titleName.setText(ResourceUtils.getString(R.string.regist));
		ivMenu.setVisibility(View.GONE);
	}

	@Override
	public void initView() {
		new RegistPresenter(this);
		presenter.start();
		initBind();
	}

	private void initBind() {
		RxView.clicks(btnRegist)
			.throttleFirst(Constant.CLICK_INTERVER, TimeUnit.MILLISECONDS)   //两秒钟之内只取一个点击事件，防抖操作
			.subscribe(new Action1<Void>() {
				@Override
				public void call(Void aVoid) {
					presenter.regist(getUserName(), getUserPsw());
				}
			});
	}

	@Override
	public void initData() {
	}

	@Override
	public void onRegistSuccess() {
		Toast.showSuccessToast("注册成功");
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);

		Activity activity = ActivityStack.findActivity("com.flydance.tutu.login.LoginActivity");
		if (activity != null) {
			activity.finish();
		}

		finish();
	}

	@Override
	public void onRegistFail(String msg) {

		//注册失败
	}

	@Override
	public String getUserName() {
		return etUsername.getText().toString().trim();
	}

	@Override
	public String getUserPsw() {
		return etPsw.getText().toString().trim();
	}

	@Override
	public void setUserName(String userName) {
		etUsername.setText(userName);
	}

	@Override
	public void showLoading(String msg) {
		showLoadingDialog(msg);
	}

	@Override
	public void cancelLoading() {
		cancelLoadingDialog();
	}

	@Override
	public void setPresenter(RegistContract.Presenter presenter) {
		this.presenter = presenter;
	}
}
