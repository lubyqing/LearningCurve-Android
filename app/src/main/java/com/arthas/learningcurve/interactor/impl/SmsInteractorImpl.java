package com.arthas.learningcurve.interactor.impl;

import com.arthas.learningcurve.executor.PostExecutionThread;
import com.arthas.learningcurve.executor.ThreadExecutor;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.repository.SmsRepository;

import rx.Observable;

import javax.inject.Inject;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class SmsInteractorImpl extends BaseInteractor {

    @Inject
    SmsRepository smsRepository;
    private String mobile;

    @Inject
    public SmsInteractorImpl(SmsRepository smsRepository,ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.smsRepository = smsRepository;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return smsRepository.sendSmsVerifyCode(mobile);
    }

}
