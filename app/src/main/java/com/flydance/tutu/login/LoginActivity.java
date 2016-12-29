package com.flydance.tutu.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.flydance.basemodule.utils.RegexUtils;
import com.flydance.tutu.AppUI.Toast;
import com.flydance.tutu.R;
import com.flydance.tutu.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {

    @Bind(R.id.email)
    EditText email;
    @Bind(R.id.password)
    EditText password;


    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.email_sign_in_button})
    public void onClick(View view) {
        attemptLogin();
    }


    private void attemptLogin() {
        // Reset errors.
        email.setError(null);
        password.setError(null);

        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();

        boolean cancel = false;
        View focusView = null;


        if (TextUtils.isEmpty(emailString)) {
            Toast.showToast(getString(R.string.error_field_required));
            focusView = email;
            cancel = true;
        } else if (!isEmailValid(emailString)) {
            Toast.showToast(getString(R.string.error_invalid_username));
            focusView = email;
            cancel = true;
        } else if (!isPasswordValid(passwordString)) {
            Toast.showToast(getString(R.string.error_invalid_password));
            focusView = password;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            //请求登录
            Toast.showToast(getString(R.string.error_invalid_username));
        }
    }

    private boolean isEmailValid(String email) {

        return RegexUtils.isMobileExact(email);
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 6;
    }

}

