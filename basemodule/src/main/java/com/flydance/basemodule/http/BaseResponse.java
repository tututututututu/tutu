package com.flydance.basemodule.http;

import java.io.Serializable;

/**
 * Created by tutu on 2017/1/10.
 */

public class BaseResponse<T> implements Serializable {
	boolean success;
	String code;
	String msg;
	T data;

	public BaseResponse() {
	}

	public boolean isSuccess() {

		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
