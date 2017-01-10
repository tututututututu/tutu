package com.flydance.tutu.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by tutu on 2016/12/31.
 */

public class UserBean extends BmobUser {
	//性别
	String sex;
	//等级
	Integer level;
	//昵称
	String nickName;
	//头像地址
	String portraits;
	//额外信息 json结构
	String extra;


	public UserBean() {

	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPortraits() {
		return portraits;
	}

	public void setPortraits(String portraits) {
		this.portraits = portraits;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}


	@Override
	public String toString() {
		return "UserBean{" +
			"sex='" + sex + '\'' +
			", level='" + level + '\'' +
			", nickName='" + nickName + '\'' +
			", portraits='" + portraits + '\'' +
			", extra='" + extra + '\'' +
			'}';
	}
}
