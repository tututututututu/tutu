package com.flydance.tutu.fragment.historyToday;

import com.flydance.basemodule.http.RxHelper;
import com.flydance.basemodule.http.RxSubscribe;
import com.flydance.tutu.bean.HistoryTodayListBean;

import java.util.List;

/**
 * Created by tutu on 2017/1/10.
 */

public class HistoryTodayPresenter implements HistoryTodayContract.Presenter {

    private HistoryTodayContract.View view;

    public HistoryTodayPresenter(HistoryTodayContract.View view) {
        this.view = view;
    }

    @Override
    public void requestList(String date) {
        view.onLoading();
        HistoryTodayModel.getHistoryTodayList(date)
                .compose(RxHelper.<List<HistoryTodayListBean>>RxHandleResult())
                .subscribe(new RxSubscribe<List<HistoryTodayListBean>>() {

                    @Override
                    protected void onSuccess(List<HistoryTodayListBean> historyTodayListBean) {
                        view.onLoadData(historyTodayListBean);
                        if (historyTodayListBean != null && historyTodayListBean.size() > 0) {
                            view.onSucceess();
                        } else {
                            view.onEmptyData();
                        }

                    }

                    @Override
                    protected void onFail(String msg) {
                        view.onFail(msg);
                        view.onError(msg);
                    }
                });
    }

    @Override
    public void start() {
        requestList(view.getDate());
    }
}
