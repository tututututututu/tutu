package com.flydance.tutu.activity.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.flydance.basemodule.utils.ResourceUtils;
import com.flydance.tutu.R;
import com.flydance.tutu.activity.main.MainActivity;
import com.flydance.tutu.activity.regist.RegistActivity;
import com.flydance.tutu.app.Constant;
import com.flydance.tutu.base.BaseActivity;
import com.flydance.tutu.widget.Toast;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.functions.Action1;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {


	LoginContract.Presenter presenter;
	@Bind(R.id.et_username)
	EditText etUsername;
	@Bind(R.id.et_psw)
	EditText etPsw;
	@Bind(R.id.btn_login)
	Button btnLogin;
	@Bind(R.id.tv_regist)
	TextView tvRegist;
	@Bind(R.id.login_form)
	ScrollView loginForm;
	@Bind(R.id.base_layout)
	LinearLayout baseLayout;


	@Override
	public int getLayoutID() {
		return R.layout.activity_login;
	}

	@Override
	public void initTitle(TextView titleName, View ivBack, View ivMenu, View titleRoot) {
		titleName.setText(ResourceUtils.getString(R.string.login));
		ivBack.setVisibility(View.GONE);
	}

	@Override
	public void initView() {
		presenter = new LoginPresenter(this);
		presenter.start();

		initBind();
	}

	private void initBind() {
		RxView.clicks(btnLogin).throttleFirst(Constant.CLICK_INTERVER, TimeUnit.MILLISECONDS)
			.subscribe(new Action1<Void>() {
				@Override
				public void call(Void aVoid) {
					presenter.login(getUserName(), getUserPsw());
				}
			});


		RxView.clicks(tvRegist).throttleFirst(Constant.CLICK_INTERVER, TimeUnit.MILLISECONDS)
			.subscribe(new Action1<Void>() {
				@Override
				public void call(Void aVoid) {
					Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
					startActivity(intent);
				}
			});
	}


	@Override
	public void initData() {

	}


	@Override
	public void onLoginSuccess() {
		cancelLoading();
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public void onLoginFail(String msg) {
		Toast.showErrorToast(msg);
		cancelLoading();
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
	public void setPsw(String psw) {
		etPsw.setText(psw);
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
	public void setPresenter(LoginContract.Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void onEmptyData() {

	}

}

