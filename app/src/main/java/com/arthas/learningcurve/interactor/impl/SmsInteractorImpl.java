package com.arthas.learningcurve.interactor.impl;

import com.arthas.learningcurve.interactor.SmsInteractor;
import com.arthas.learningcurve.repository.SmsRepository;
import com.arthas.learningcurve.repository.impl.SmsRepositoryImpl;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import javax.inject.Inject;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class SmsInteractorImpl implements SmsInteractor {
    private SmsRepository smsRepository;
    private OnVerifyCodeSendLisenter onCallBackLisenter;

    @Inject
    public SmsInteractorImpl(OnVerifyCodeSendLisenter onCallBackLisenter) {
        this.onCallBackLisenter = onCallBackLisenter;
        this.smsRepository = new SmsRepositoryImpl();
    }

    @Override
    public void sendSmsVerifyCode(String mobile){
        smsRepository.sendSmsVerifyCode(mobile)
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(new Observer<String>() {
                         @Override
                         public void onCompleted() {

                         }

                         @Override
                         public void onError(Throwable e) {

                         }

                         @Override
                         public void onNext(String s) {
                             onCallBackLisenter.onVerifyCodeSend(s);
                         }
        });
    }


}
