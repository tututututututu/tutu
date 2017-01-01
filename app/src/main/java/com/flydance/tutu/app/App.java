package com.flydance.tutu.app;

import android.app.Application;

import com.flydance.basemodule.utils.L;
import com.flydance.basemodule.utils.SPUtils;
import com.flydance.basemodule.utils.Utils;

/**
 * Created by tutu on 2016/12/29.
 */

public class App extends Application {
	public static App app;


	@Override
	public void onCreate() {
		super.onCreate();
		app = this;
		initUtils();
		initSP();
		initLoger();
	}

	private void initLoger() {
		L.initLoger();
	}

	private void initSP() {
		SPUtils.initSP("data");
	}

	private void initUtils() {
		//初始化工具类Context
		Utils.init(this);
	}
}
