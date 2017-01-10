package com.flydance.basemodule.http;

/**
 * Created by tutu on 2017/1/10.
 */

public class BussinessException extends Exception {

	public BussinessException() {
		this(null, null);
	}
	public BussinessException(String code, String msg) {
		super(msg);
		switch (code){
			case "404":
				break;
		}


	}



}
