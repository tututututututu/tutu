package com.flydance.tutu.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by tutu on 2016/12/31.
 */

public class UserBean extends BmobObject{
	//用户名
	String userName;
	//密码
	String userPsw;
	//性别
	String sex;
	//等级
	String level;
	//昵称
	String nickName;
	//头像地址
	String portraits;
	//额外信息 json结构
	String extra;


	public UserBean(){

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
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
}
