package com.flydance.tutu.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.flydance.basemodule.utils.RegexUtils;
import com.flydance.basemodule.utils.ResourceUtils;
import com.flydance.tutu.AppUI.Toast;
import com.flydance.tutu.R;
import com.flydance.tutu.base.BaseActivity;
import com.flydance.tutu.regist.RegistActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {

	@Bind(R.id.email)
	EditText email;
	@Bind(R.id.password)
	EditText password;


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

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void initData() {

	}

	@OnClick({R.id.email_sign_in_button, R.id.tv_regist})
	public void onClick(View view) {
		Intent intent;
		switch (view.getId()) {
			case R.id.email_sign_in_button:
				break;
			case R.id.tv_regist:
				intent = new Intent(this, RegistActivity.class);
				startActivity(intent);
				break;
		}
	}


	private void attemptLogin() {
		// Reset errors.
		email.setError(null);
		password.setError(null);

		String emailString = email.getText().toString();
		String passwordString = password.getText().toString();

		boolean cancel = false;
		View focusView = null;


		if (TextUtils.isEmpty(emailString)) {
			Toast.showErrorToast(getString(R.string.error_field_required));
			focusView = email;
			cancel = true;
		} else if (!isEmailValid(emailString)) {
			Toast.showErrorToast(getString(R.string.error_invalid_username));
			focusView = email;
			cancel = true;
		} else if (!isPasswordValid(passwordString)) {
			Toast.showErrorToast(getString(R.string.error_invalid_password));
			focusView = password;
			cancel = true;
		}

		if (cancel) {
			focusView.requestFocus();
		} else {
			//请求登录
			Toast.showErrorToast(getString(R.string.error_invalid_username));
		}
	}

	private boolean isEmailValid(String email) {

		return RegexUtils.isMobileExact(email);
	}

	private boolean isPasswordValid(String password) {
		return password.length() > 6;
	}

}

