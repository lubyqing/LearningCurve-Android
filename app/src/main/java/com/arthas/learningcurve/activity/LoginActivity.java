package com.arthas.learningcurve.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.injection.HasComponent;
import com.arthas.learningcurve.injection.component.DaggerUserManageComponent;
import com.arthas.learningcurve.injection.component.UserManageComponent;
import com.arthas.learningcurve.injection.module.UserManageModule;
import com.arthas.learningcurve.interfaceview.LoginView;
import com.arthas.learningcurve.model.UserInfoModel;
import com.arthas.learningcurve.presenter.LoginPresenter;
import com.arthas.learningcurve.widget.BaseProgressDialog;
import com.arthas.learningcurve.widget.HeaderBar;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginView, HasComponent<UserManageComponent> {

    @Bind(R.id.et_user_mobile)
    EditText mMobileEt;
    @Bind(R.id.et_verify_code)
    EditText mVerifyCodeEt;

    @Bind(R.id.view_header_bar)
    HeaderBar mHeaderBar;

    private BaseProgressDialog mProgressDialog;

    @Inject
    LoginPresenter mLoginPresenter;

    private UserManageComponent userManageComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        mProgressDialog = BaseProgressDialog.createDialog(this);

        this.userManageComponent = DaggerUserManageComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .userManageModule(new UserManageModule())
                .build();
        userManageComponent.inject(this);

        mLoginPresenter.setView(this);
    }

    @Override
    public CharSequence getUserMobile() {
        return mMobileEt.getText();
    }

    @Override
    public CharSequence getUserVerifyCode() {
        return mVerifyCodeEt.getText();
    }

    @Override
    public void onVerifyCodeSended(String msg) {
        showToast(msg);
    }

    @Override
    public void onLogined(UserInfoModel model) {
        showToast(model.getMessage());
        Intent intent = getIntent();
        try {
            intent.setClass(this, Class.forName(intent.getStringExtra(Constant.KEY_CLASS_NAME)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void dismissLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showErrorMsg(int errorId) {
        showToast(errorId);
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        showToast(errorMsg);
    }

    @OnClick({R.id.btn_get_verify_code, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get_verify_code:
                mLoginPresenter.sendSmsVerifyCode();
                break;
            case R.id.btn_login:
                mLoginPresenter.login();
                break;
        }
    }

    @Override
    public UserManageComponent getComponent() {
        return userManageComponent;
    }
}
