package com.flydance.tutu.activity.login;

import android.text.TextUtils;

import com.flydance.basemodule.http.RxHelper;
import com.flydance.basemodule.http.RxSubscribe;
import com.flydance.basemodule.utils.RegexUtils;
import com.flydance.basemodule.utils.SPUtils;
import com.flydance.tutu.R;
import com.flydance.tutu.app.Constant;
import com.flydance.tutu.bean.UserBean;
import com.flydance.tutu.widget.Toast;

import static com.flydance.basemodule.utils.ResourceUtils.getString;

/**
 * Created by tutu on 2016/12/31.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;
    private LoginModel loginModel;


    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        view.setPresenter(this);
        loginModel = new LoginModel();
    }

    @Override
    public void login(final String userName, final String userPsw) {
        if (!verifyInput(userName, userPsw)) {
            return;
        }


        //使用缓存用户登录
        if (UserBean.getCurrentUser() != null && UserBean.getCurrentUser().getUsername().equals(userName) && userPsw
                .equals("******")) {
            //直接登陆成功
            view.onLoginSuccess();
            return;
        }


        view.showLoading("登陆中...");
        loginModel.login(userName, userPsw)
                .compose(RxHelper.<UserBean>switchSchedulers())
                .subscribe(new RxSubscribe<UserBean>() {
                    @Override
                    protected void onSuccess(UserBean userBean) {
                        if (userBean != null) {
                            //登陆成功
                            SPUtils.putString(Constant.USER_PORTRAINS, userBean.getPortraits());
                            SPUtils.putString(Constant.USER_NICKNAME, userBean.getNickName());
                            view.onLoginSuccess();
                        } else {
                            view.cancelLoading();
                            view.onLoginFail("登陆失败");
                        }
                    }

                    @Override
                    protected void onFail(String msg) {
                        view.cancelLoading();
                        view.onLoginFail("登陆失败");
                    }

                    @Override
                    protected void onNetError(String msg) {
                        view.cancelLoading();
                        view.onLoginFail("登陆失败");
                    }
                });
    }

    @Override
    public void start() {
        if (UserBean.getCurrentUser() != null && !TextUtils.isEmpty(UserBean.getCurrentUser().getUsername())) {
            view.setUserName(UserBean.getCurrentUser().getUsername());
            view.setPsw("******");
        }


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
