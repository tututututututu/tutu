package com.flydance.basemodule.http;

import java.io.Serializable;

/**
 * Created by tutu on 2017/1/10.
 */

public class BaseResponse<T> implements Serializable {
	String reason;
	String error_code;
	T result;

	public BaseResponse() {
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "BaseResponse{" +
				"reason='" + reason + '\'' +
				", error_code='" + error_code + '\'' +
				", result=" + result +
				'}';
	}
}
