package com.flydance.basemodule.utils;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by tutu on 2017/1/1.
 * 日志类
 */

public class L {
	public static void initLoger() {
		Logger
			//.init(YOUR_TAG)                 // default PRETTYLOGGER or use just init()
			.init()                 // default PRETTYLOGGER or use just init()
			.methodCount(2)                 // default 2
			//.hideThreadInfo()               // default shown
			//.logLevel(LogLevel.NONE)        // default LogLevel.FULL
			.logLevel(LogLevel.FULL)        // default LogLevel.FULL
			.methodOffset(2);                // default 0
		//.logAdapter(new AndroidLogAdapter()); //default AndroidLogAdapter
	}

	public static void e(String message, Object... args) {
		Logger.e("response"+message, args);
	}

	public static void i(String message, Object... args) {
		Logger.i("response"+message, args);
	}

	public static void w(String message, Object... args) {
		Logger.w("response"+message, args);
	}

	public static void v(String message, Object... args) {
		Logger.v("response"+message, args);
	}

	public static void json(String json) {
		Logger.e("response json=");
		Logger.json(json);
	}

	public static void d(String message, Object... args) {
		Logger.d("response"+message, args);
	}

	/**
	 * 以下带r的都是请求日志，上面都是返回日志
	 * @param message
	 * @param args
	 */
	public static void er(String message, Object... args) {
		Logger.e("request"+message, args);
	}

	public static void ir(String message, Object... args) {
		Logger.i("request"+message, args);
	}

	public static void wr(String message, Object... args) {
		Logger.w("request"+message, args);
	}

	public static void vr(String message, Object... args) {
		Logger.v("request"+message, args);
	}

	public static void jsonr(String json) {
		Logger.e("request json=");
		Logger.json(json);
	}

	public static void dr(String message, Object... args) {
		Logger.d("request"+message, args);
	}
}
