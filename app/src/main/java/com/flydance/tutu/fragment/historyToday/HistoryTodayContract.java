package com.flydance.tutu.fragment.historyToday;

import com.flydance.tutu.base.BaseStatusView;
import com.flydance.tutu.base.IBasePresenter;
import com.flydance.tutu.bean.HistoryTodayListBean;

import java.util.List;

/**
 * Created by tutu on 2017/1/10.
 */

public class HistoryTodayContract {

	interface Presenter extends IBasePresenter {
		void requestList(String date);
	}


	interface View extends BaseStatusView<Presenter> {
		void onLoadData(List<HistoryTodayListBean> listBeen);
		String getDate();
	}
}
