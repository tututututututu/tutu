package com.flydance.tutu.regist;

import com.flydance.tutu.bean.UserBean;

import rx.Observable;

/**
 * Created by tutu on 2016/12/31.
 */

public class RegistModel{

	public Observable<String> regist(UserBean userBean){
		return userBean.saveObservable();
	}

}
