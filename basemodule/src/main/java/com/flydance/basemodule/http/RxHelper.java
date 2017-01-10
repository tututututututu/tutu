package com.flydance.basemodule.http;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by tutu on 2017/1/10.
 */

public class RxHelper {

	public static <T> Observable.Transformer<BaseResponse<T>, T> RxHandleResult() {

		return baseResponseObservable -> baseResponseObservable.flatMap(new Func1<BaseResponse<T>, Observable<T>>() {
			@Override
			public Observable<T> call(BaseResponse<T> tBaseResponse) {
				if ("success".equals(tBaseResponse.getReason())) {
					return createData(tBaseResponse.getResult());
				} else {
					return Observable.error(new BussinessException(tBaseResponse.getError_code(), tBaseResponse
						.getReason()));
				}
			}
		}).compose(switchSchedulers());
	}

	private static <T> Observable<T> createData(T data) {
		return Observable.create(new Observable.OnSubscribe<T>() {
			@Override
			public void call(Subscriber<? super T> subscriber) {
				try {
					subscriber.onNext(data);
					subscriber.onCompleted();
				} catch (Exception e) {
					subscriber.onError(e);
				}
			}
		});
	}

	public static <T> Observable.Transformer<T, T> switchSchedulers() {
		return observable -> observable.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread());
	}
}
