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
		/**
		 * @param date 日期
		 * @param hasData 是否已经有数据了
		 */
		void requestList(String date,boolean hasData);
	}


	interface View extends BaseStatusView<Presenter> {
		void onLoadData(List<HistoryTodayListBean> listBeen);
		void onFail(String msg);
		String getDate();
	}
}
