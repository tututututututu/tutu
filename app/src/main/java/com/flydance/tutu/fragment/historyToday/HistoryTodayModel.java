package com.flydance.tutu.fragment.historyToday;

import com.flydance.basemodule.http.BaseResponse;
import com.flydance.tutu.bean.HistoryTodayListBean;
import com.flydance.tutu.http.Api;

import rx.Observable;

/**
 * Created by tutu on 2017/1/10.
 */

public class HistoryTodayModel {

	public static Observable<BaseResponse<HistoryTodayListBean>> getHistoryTodayList(String date) {
		return Api.getInstance().getHistoryTodayList(date);
	}
}
