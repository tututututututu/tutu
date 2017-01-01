package com.flydance.tutu.regist;

import com.flydance.basemodule.utils.L;
import com.flydance.tutu.bean.UserBean;

import rx.Observable;

/**
 * Created by tutu on 2016/12/31.
 */

public class RegistModel {
	public Observable<UserBean> regist(UserBean userBean) {
		L.ir(getClass().getSimpleName(), userBean.toString());
		return userBean.signUpObservable(UserBean.class);
	}

}
