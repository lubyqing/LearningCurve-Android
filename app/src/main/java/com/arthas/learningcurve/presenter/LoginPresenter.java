package com.arthas.learningcurve.presenter;

import android.text.TextUtils;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.interactor.DefaultSubscriber;
import com.arthas.learningcurve.interactor.impl.LoginInteractorImpl;
import com.arthas.learningcurve.interactor.impl.SmsInteractorImpl;
import com.arthas.learningcurve.interfaceview.LoginView;
import com.arthas.learningcurve.utils.InputValidatorUtils;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class LoginPresenter{
    private LoginView mLoginView;

    @Inject
            @Named("smsInteractor")
    BaseInteractor smsInteractor;

    @Inject
    @Named("loginInteractor")
    BaseInteractor loginInteractor;

    @Inject
    public LoginPresenter() {
    }


    public void setView(LoginView mLoginView) {
        this.mLoginView = mLoginView;
    }


    public void sendSmsVerifyCode() {
        CharSequence mobile = mLoginView.getUserMobile();
        if (TextUtils.isEmpty(mobile)) {
            mLoginView.showErrorMsg(R.string.login_mobile_is_null);
            return;
        }

        if (!InputValidatorUtils.isMobile(mobile.toString())) {
            mLoginView.showErrorMsg(R.string.login_mobile_error);
            return;
        }
        mLoginView.showLoading();

        ((SmsInteractorImpl) smsInteractor).setMobile(mobile.toString());
        smsInteractor.execute(new DefaultSubscriber<String>() {
            @Override
            public void onNext(String s) {
                super.onNext(s);
                mLoginView.showErrorMsg(s);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mLoginView.dismissLoading();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mLoginView.dismissLoading();
            }
        });

    }


    public void login() {
        CharSequence mobile = mLoginView.getUserMobile();
        if (TextUtils.isEmpty(mobile)) {
            mLoginView.showErrorMsg(R.string.login_mobile_is_null);
            return;
        }

        if (!InputValidatorUtils.isMobile(mobile.toString())) {
            mLoginView.showErrorMsg(R.string.login_mobile_error);
            return;
        }

        CharSequence verifyCode = mLoginView.getUserVerifyCode();
        if (TextUtils.isEmpty(verifyCode)) {
            mLoginView.showErrorMsg(R.string.login_verify_code_is_null);
            return;
        }

        mLoginView.showLoading();
        ((LoginInteractorImpl) loginInteractor).setMobile(mobile.toString());
        ((LoginInteractorImpl) loginInteractor).setVerifyCode(verifyCode.toString());
        loginInteractor.execute(new DefaultSubscriber<String>() {
            @Override
            public void onNext(String s) {
                super.onNext(s);
//                mLoginView.showErrorMsg(s);
                 mLoginView.onLogined();
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mLoginView.dismissLoading();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mLoginView.dismissLoading();
            }
        });

    }

}
