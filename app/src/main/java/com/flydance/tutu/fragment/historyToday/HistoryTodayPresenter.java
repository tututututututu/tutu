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
        HistoryTodayModel.getHistoryTodayList(date)
                .compose(RxHelper.<List<HistoryTodayListBean>>RxHandleResult())
                .subscribe(new RxSubscribe<List<HistoryTodayListBean>>() {

                    @Override
                    protected void onSuccess(List<HistoryTodayListBean> historyTodayListBean) {
                        //L.ir(historyTodayListBean.toString());
                        //view.onSucceess(historyTodayListBean);
                    }

                    @Override
                    protected void onFail(String msg) {

                    }
                });
    }

    @Override
    public void start() {
        requestList(view.getDate());
    }
}
