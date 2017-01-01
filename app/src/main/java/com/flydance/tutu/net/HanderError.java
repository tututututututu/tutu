package com.flydance.tutu.net;

import com.flydance.basemodule.utils.L;
import com.flydance.tutu.AppUI.Toast;

import rx.functions.Func1;

/**
 * Created by tutu on 2017/1/1.
 */

public class HanderError implements Func1<Throwable, String> {
	@Override
	public String call(Throwable throwable) {
		String code = getCodeError(throwable.toString());

		L.e(getClass().getSimpleName(), throwable);
		switch (code) {
			//SDK 相关错误
			case "9001":
				Toast.showErrorToast("Application Id为空，请初始化");
				break;
			case "9002":
				Toast.showErrorToast("解析返回数据出错");
				break;
			case "9003":
				Toast.showErrorToast("上传文件出错");
				break;
			case "9004":
				Toast.showErrorToast("文件上传失败");
				break;
			case "9005":
				Toast.showErrorToast("批量操作只支持最多50条");
				break;
			case "9006":
				Toast.showErrorToast("objectId为空");
				break;
			case "9007":
				Toast.showErrorToast("文件大小超过10M");
				break;
			case "9008":
				Toast.showErrorToast("上传文件不存在");
				break;
			case "9009":
				Toast.showErrorToast("没有缓存数据");
				break;
			case "9010":
				Toast.showErrorToast("网络超时");
				break;
			case "9011":
				Toast.showErrorToast("BmobUser类不支持批量操作");
				break;
			case "9012":
				Toast.showErrorToast("上下文为空");
				break;
			case "9013":
				Toast.showErrorToast("（数据表名称）格式不正确");
				break;
			case "9014":
				Toast.showErrorToast("第三方账号授权失败");
				break;
			case "9015":
				Toast.showErrorToast("其他错误");
				break;
			case "9016":
				Toast.showErrorToast("无网络连接，请检查您的手机网络");
				break;
			case "9017":
				Toast.showErrorToast("第三方登录有关的错误");
				break;
			case "9018":
				Toast.showErrorToast("参数不能为空");
				break;
			case "9019":
				Toast.showErrorToast("数据格式不正确");
				break;
			case "401":
				Toast.showErrorToast("唯一键不能存在重复的值");
				break;
			case "500":
				Toast.showErrorToast("服务器繁忙,稍后再试");
				break;

			case "101":
				Toast.showErrorToast("用户名或密码不正确");
				break;
			case "102":
				Toast.showErrorToast("数据格式不正确");
				break;
			case "103":
				Toast.showErrorToast("objectId为空");
				break;
			case "104":
				Toast.showErrorToast("关联的class名称不存在");
				break;
			case "105":
				Toast.showErrorToast("字段名是大小写敏感的");
				break;
			case "106":
				Toast.showErrorToast("不是一个正确的指针类型");
				break;
			case "107":
				Toast.showErrorToast("请求格式不正确");
				break;
			case "108":
				Toast.showErrorToast("用户名和密码是必需的");
				break;
			case "109":
				Toast.showErrorToast("登录信息是必需的");
				break;
			case "111":
				Toast.showErrorToast("传入的字段值与字段类型不匹配");
				break;
			case "112":
				Toast.showErrorToast("requests的值必须是数组");
				break;
			case "113":
				Toast.showErrorToast("请求数据不是json");
				break;
			case "114":
				Toast.showErrorToast("requests数组大于50");
				break;
			case "202":
				Toast.showErrorToast("账号已被注册");
				break;
			case "1002":
				Toast.showErrorToast("该应用能创建的表数已达到限制");
				break;
			case "1003":
				Toast.showErrorToast("该表的行数已达到限制");
				break;
			case "1004":
				Toast.showErrorToast("该表的列数已达到限制");
				break;
			case "1005":
				Toast.showErrorToast("每月api请求数量已达到限制");
				break;
			case "1006":
				Toast.showErrorToast("该应用能创建定时任务数已达到限制");
				break;
			case "1007":
				Toast.showErrorToast("该应用能创建云端逻辑数已达到限制");
				break;
			case "1500":
				Toast.showErrorToast("你上传的文件大小已超出限制");
				break;
			default:
				Toast.showErrorToast(throwable.toString());
				break;
		}
		return null;
	}

	private String getCodeError(String s) {
		if (!s.contains("errorCode")) {
			return null;
		}
		int start = s.indexOf(":");
		int end = s.indexOf(",");
		return s.substring(start + 1, end);
	}
}
