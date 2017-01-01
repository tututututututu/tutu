package com.flydance.tutu.login;

import com.flydance.basemodule.utils.L;
import com.flydance.tutu.bean.UserBean;

import cn.bmob.v3.BmobUser;
import rx.Observable;

/**
 * Created by tutu on 2016/12/31.
 */

public class LoginModel {
	public Observable<UserBean> login(String userName, String psw) {
		L.ir(getClass().getSimpleName(), userName + " " + psw);
		return BmobUser.loginByAccountObservable(UserBean.class, userName, psw);
	}

}
