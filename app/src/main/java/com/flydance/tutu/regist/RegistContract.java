package com.flydance.tutu.regist;

import com.flydance.tutu.base.BaseView;
import com.flydance.tutu.base.IBasePresenter;

/**
 * Created by tutu on 2016/12/31.
 */

public class RegistContract {
	interface Presenter extends IBasePresenter {
		void regist(String userName, String userPsw);
	}

	interface View extends BaseView<Presenter> {
		void onRegistSuccess();

		void onRegistFail(String msg);

		String getUserName();

		String getUserPsw();

		void setUserName(String userName);
	}
}
