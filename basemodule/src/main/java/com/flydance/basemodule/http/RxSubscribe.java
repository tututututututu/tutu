package com.flydance.basemodule.http;

import com.flydance.basemodule.utils.NetworkUtils;

import rx.Subscriber;

/**
 * Created by tutu on 2017/1/10.
 */

public abstract class RxSubscribe<T> extends Subscriber<T> {
	protected abstract void onSuccess(T t);

	protected abstract void onFail(String msg);

	@Override
	public void onNext(T t) {
		onSuccess(t);
	}


	@Override
	public void onError(Throwable e) {
		e.printStackTrace();
		if (!NetworkUtils.isConnected()) {
			onFail("网络不可用");
		} else if (e instanceof BussinessException) {
			onFail(e.getMessage());
		} else {
			onFail("请求失败,请稍后再试");
		}
	}


	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onCompleted() {
	}
}
