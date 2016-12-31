package com.flydance.tutu.app;

import android.app.Application;

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
	}

	private void initUtils() {
		//初始化工具类Context
		Utils.init(this);
	}
}
