package com.flydance.tutu.loading;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flydance.tutu.R;
import com.flydance.tutu.base.BaseActivity;
import com.flydance.tutu.login.LoginActivity;

import butterknife.Bind;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

public class LoadingActivity extends BaseActivity {
	@Bind(R.id.iv_splash)
	ImageView ivSplash;

	@Override
	public int getLayoutID() {
		return R.layout.activity_loading;
	}

	@Override
	public void initTitle(TextView titleName, View ivBack, View ivMenu, View titleRoot) {
		titleRoot.setVisibility(View.GONE);
	}

	@Override
	public void initView() {
		ivSplash.postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(LoadingActivity.this, LoginActivity.class);
				startActivity(intent);
			}
		}, 2000);
		initBomb();
	}

	@Override
	public void initData() {

	}


	private void initBomb() {
		//第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
		BmobConfig config = new BmobConfig.Builder(this)
			////设置appkey
			.setApplicationId("2215f51f9ee3e4f3c9674674c989d017")
			////请求超时时间（单位为秒）：默认15s
			.setConnectTimeout(30)
			////文件分片上传时每片的大小（单位字节），默认512*1024
			.setUploadBlockSize(1024 * 1024)
			////文件的过期时间(单位为秒)：默认1800s
			.setFileExpiration(2500)
			.build();
		Bmob.initialize(config);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
