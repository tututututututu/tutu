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
	public void requestList(String date, final boolean isFirst) {
		if (isFirst) {
			view.onLoading();
		}
		HistoryTodayModel.getHistoryTodayList(date)
			.compose(RxHelper.<List<HistoryTodayListBean>>RxHandleResult())
			.subscribe(new RxSubscribe<List<HistoryTodayListBean>>() {

				@Override
				protected void onSuccess(List<HistoryTodayListBean> historyTodayListBean) {

					if (historyTodayListBean != null && historyTodayListBean.size() > 0) {
						view.onLoadData(historyTodayListBean);
					} else {
						view.onError("没有数据啦");
					}
				}

				@Override
				protected void onFail(String msg) {
					view.onError(msg);
				}

				@Override
				protected void onNetError(String msg) {
					if (isFirst) {
						view.onNetError();
					}else {
						view.onFail(msg);
					}
				}
			});
	}

	@Override
	public void start() {
		requestList(view.getDate(), true);
	}
}
