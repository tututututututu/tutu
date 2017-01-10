package com.flydance.tutu.fragment.historyToday;

import com.flydance.tutu.base.BaseView;
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


	interface View extends BaseView<Presenter> {
		void onSucceess(List<HistoryTodayListBean> listBeen);

		void onFail(String msg);

		String getDate();
	}
}
