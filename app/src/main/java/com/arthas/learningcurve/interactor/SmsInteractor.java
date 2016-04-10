package com.arthas.learningcurve.interactor;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface SmsInteractor {
    interface OnVerifyCodeSendLisenter {
        void onVerifyCodeSend(String str);
    }

    void sendSmsVerifyCode(String mobile);
}
