package com.flydance.tutu.AppUI;

import com.flydance.tutu.app.App;
import com.sdsmdg.tastytoast.TastyToast;

/**
 * Created by tutu on 2016/12/29.
 */

public class Toast {

	public static void showSuccessToast(String text) {
		TastyToast.makeText(App.app, text, TastyToast.LENGTH_SHORT,
			TastyToast.SUCCESS);
	}

	public static void showWarningToast(String text) {
		TastyToast.makeText(App.app, text, TastyToast.LENGTH_SHORT,
			TastyToast.WARNING);
	}

	public static void showErrorToast(String text) {
		TastyToast.makeText(App.app, text, TastyToast.LENGTH_SHORT,
			TastyToast.ERROR);
	}

	public static void showInfoToast(String text) {
		TastyToast.makeText(App.app, text, TastyToast.LENGTH_SHORT,
			TastyToast.INFO);
	}

	public static void showDefaultToast(String text) {
		TastyToast.makeText(App.app, text, TastyToast.LENGTH_SHORT,
			TastyToast.DEFAULT);
	}


	public static void showConfusingToast(String text) {
		TastyToast.makeText(App.app, text, TastyToast.LENGTH_SHORT,
			TastyToast.CONFUSING);
	}

}
