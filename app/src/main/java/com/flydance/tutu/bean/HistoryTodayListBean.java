package com.flydance.tutu.bean;

import com.flydance.basemodule.http.BaseResponse;

/**
 * Created by tutu on 2017/1/10.
 */

public class HistoryTodayListBean extends BaseResponse {
	/**
	 * day : 1/1
	 * date : 前45年01月01日
	 * title : 罗马共和国开始使用儒略历
	 * e_id : 1
	 */

	private String day;
	private String date;
	private String title;
	private String e_id;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getE_id() {
		return e_id;
	}

	public void setE_id(String e_id) {
		this.e_id = e_id;
	}

	@Override
	public String toString() {
		return "HistoryTodayListBean{" +
			"day='" + day + '\'' +
			", date='" + date + '\'' +
			", title='" + title + '\'' +
			", e_id='" + e_id + '\'' +
			'}';
	}
}
