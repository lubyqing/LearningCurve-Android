package com.arthas.learningcurve.interfaceview;

import com.arthas.learningcurve.model.UserInfoModel;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface LoginView extends BaseView{

    CharSequence getUserMobile();
    CharSequence getUserVerifyCode();

    void onVerifyCodeSended(String msg);
    void onLogined(UserInfoModel model);




}
