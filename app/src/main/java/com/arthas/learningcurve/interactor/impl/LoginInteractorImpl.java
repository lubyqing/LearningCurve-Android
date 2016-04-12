package com.arthas.learningcurve.interactor.impl;

import com.arthas.learningcurve.executor.PostExecutionThread;
import com.arthas.learningcurve.executor.ThreadExecutor;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.repository.UserManageRepository;

import rx.Observable;

import javax.inject.Inject;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class LoginInteractorImpl  extends BaseInteractor {
    private UserManageRepository userManageRepository;
    private String mobile;
    private String verifyCode;

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Inject
    public LoginInteractorImpl(UserManageRepository userManageRepository, ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread) {
        super(threadExecutor,postExecutionThread);
        this.userManageRepository = userManageRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userManageRepository.login(mobile, verifyCode);
    }
}
