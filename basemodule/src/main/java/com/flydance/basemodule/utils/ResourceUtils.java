package com.flydance.basemodule.utils;

/**
 * Created by tutu on 2016/12/31.
 */

public class ResourceUtils {
	public static String getString(int resID) {
		return Utils.getContext().getResources().getString(resID);
	}

	public static int getColor(int resID) {
		return Utils.getContext().getResources().getColor(resID);
	}
}
