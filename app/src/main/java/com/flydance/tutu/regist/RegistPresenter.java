package com.flydance.tutu.regist;

import com.flydance.tutu.bean.UserBean;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tutu on 2016/12/31.
 */

public class RegistPresenter implements RegistContract.Presenter {
	private RegistContract.View view;
	private RegistModel registModel;


	public RegistPresenter(RegistContract.View view) {
		this.view = view;
		view.setPresenter(this);
		registModel = new RegistModel();
	}

	@Override
	public void regist(String userName, String userPsw) {

		UserBean userBean = new UserBean();
		userBean.setUserName(userName);
		userBean.setUserPsw(userPsw);
		userBean.setNickName("hehe");
		userBean.setSex("男");
		userBean.setLevel("钻石");
		registModel.regist(userBean).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
			.subscribe(new Observer<String>() {
				@Override
				public void onCompleted() {

				}

				@Override
				public void onError(Throwable throwable) {
					view.onRegistFail(throwable.toString());
				}

				@Override
				public void onNext(String s) {
					view.onRegistSuccess();
				}
			});
	}

	@Override
	public void start() {

	}
}
