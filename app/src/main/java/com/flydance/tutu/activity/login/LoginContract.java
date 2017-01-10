package com.flydance.tutu.activity.login;

import com.flydance.tutu.base.BaseView;
import com.flydance.tutu.base.IBasePresenter;

/**
 * Created by tutu on 2016/12/31.
 */

public class LoginContract {
	interface Presenter extends IBasePresenter {
		void login(String userName, String userPsw);
	}

	interface View extends BaseView<Presenter> {
		void onLoginSuccess();

		void onLoginFail(String msg);

		String getUserName();

		String getUserPsw();

		void setUserName(String userName);

		void setPsw(String psw);

		void showLoading(String msg);

		void cancelLoading();
	}
}
