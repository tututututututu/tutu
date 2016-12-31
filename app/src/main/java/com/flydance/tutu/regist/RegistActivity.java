package com.flydance.tutu.regist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flydance.basemodule.utils.ResourceUtils;
import com.flydance.tutu.AppUI.Toast;
import com.flydance.tutu.R;
import com.flydance.tutu.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
	}

	@Override
	public void initData() {

	}

	@OnClick({R.id.btn_regist})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btn_regist:
				presenter.regist(getUserName(), getUserPsw());
				break;

		}
	}

	@Override
	public void onRegistSuccess() {
		Toast.showSuccessToast("注册成功");
	}

	@Override
	public void onRegistFail(String msg) {
		Toast.showSuccessToast(msg);
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
	public void setPresenter(RegistContract.Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO: add setContentView(...) invocation
		ButterKnife.bind(this);
	}
}
