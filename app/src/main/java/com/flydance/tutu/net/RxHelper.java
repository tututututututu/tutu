package com.flydance.tutu.net;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tutu on 16-11-17
 * Description: Rx 一些巧妙的处理
 * Edited by xz
 */
public class RxHelper {

	/**
	 * 线程转换
	 * @param <T>
	 * @return
	 */
	public static <T> Observable.Transformer<T, T> ThreadScheduler() {
		return new Observable.Transformer<T, T>() {
			@Override
			public Observable<T> call(Observable<T> observable) {
				return observable.subscribeOn(Schedulers.io())
					.observeOn(AndroidSchedulers.mainThread());
			}
		};

	}
}
