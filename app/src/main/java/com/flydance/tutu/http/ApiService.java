package com.flydance.tutu.http;

import com.flydance.basemodule.http.BaseResponse;
import com.flydance.tutu.bean.HistoryTodayListBean;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by tutu on 2017/1/10.
 */

public interface ApiService {

	/**
	 * 获取历史的今天列表
	 *
	 * @param date 日期,格式:月/日 如:1/1,/10/1,12/12 如月或者日小于10,前面无需加0
	 * @return 列表observeable
	 */

	@POST("todayOnhistory/queryEvent.php")
	Observable<BaseResponse<HistoryTodayListBean>> getHistoryTodayList(
		@Query("date") String date
	);
}
