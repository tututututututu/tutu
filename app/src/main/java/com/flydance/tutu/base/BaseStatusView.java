package com.flydance.tutu.base;

/**
 * Created by tutu on 2017/1/11.
 */

public interface BaseStatusView<T> extends BaseView<T>{
    void onFail(String msg);
    void onEmptyData();
    void onError(String msg);
    void onNetError();
    void onSucceess();
    void onLoading();
}
