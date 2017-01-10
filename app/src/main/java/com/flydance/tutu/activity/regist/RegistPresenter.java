package com.flydance.tutu.activity.regist;

import android.text.TextUtils;

import com.flydance.basemodule.http.RxHelper;
import com.flydance.basemodule.utils.L;
import com.flydance.basemodule.utils.RegexUtils;
import com.flydance.basemodule.utils.SPUtils;
import com.flydance.tutu.R;
import com.flydance.tutu.app.Constant;
import com.flydance.tutu.bean.UserBean;
import com.flydance.tutu.widget.Toast;

import rx.functions.Action1;

import static com.flydance.basemodule.utils.ResourceUtils.getString;

/**
 * Created by tutu on 2016/12/31.
 */

public class RegistPresenter implements RegistContract.Presenter {
	private RegistContract.View view;
	private RegistModel registModel;


	public RegistPresenter(RegistContract.View view) {
		this.view = view;
		view.setPresenter(this);
		registModel = new RegistModel();
	}

	@Override
	public void regist(final String userName, final String userPsw) {

		UserBean userBean = new UserBean();
		userBean.setUsername(userName);
		userBean.setPassword(userPsw);
		if (!verifyInput(userName, userPsw)) {
			return;
		}
		view.showLoading("请稍候...");
		registModel.regist(userBean)
			.compose(RxHelper.<UserBean>switchSchedulers())
			.subscribe(new Action1<Object>() {
				@Override
				public void call(Object o) {
					view.cancelLoading();
					L.i(RegistPresenter.class.getSimpleName(), o);
					if (o == null) {
						view.onRegistFail("注册失败");
					} else {
						view.onRegistSuccess();
						SPUtils.putString(Constant.USER_NAME, userName);
						SPUtils.putString(Constant.USER_PSW, userPsw);
						SPUtils.putString(Constant.USER_ID, ((UserBean) o).getObjectId() + "");
					}
				}
			});
	}

	@Override
	public void start() {

	}


	private boolean verifyInput(String userName, String psw) {

		if (TextUtils.isEmpty(userName)) {
			Toast.showErrorToast(getString(R.string.error_field_required));
			return false;
		} else if (!RegexUtils.isMobileExact(userName)) {
			Toast.showErrorToast(getString(R.string.error_invalid_username));
			return false;
		} else if (TextUtils.isEmpty(psw) || psw.length() < 6) {
			Toast.showErrorToast(getString(R.string.error_invalid_password));
			return false;
		}
		return true;
	}
}
