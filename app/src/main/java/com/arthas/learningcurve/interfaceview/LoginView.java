package com.arthas.learningcurve.interfaceview;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface LoginView extends BaseView{

    CharSequence getUserMobile();
    CharSequence getUserVerifyCode();

    void onVerifyCodeSended();
    void onLogined();




}
