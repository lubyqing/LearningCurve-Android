package com.arthas.learningcurve.interactor.impl;

import com.arthas.learningcurve.executor.PostExecutionThread;
import com.arthas.learningcurve.executor.ThreadExecutor;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.repository.UserManageRepository;
import com.arthas.learningcurve.repository.impl.UserManageRepositoryImpl;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import javax.inject.Inject;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class LoginInteractorImpl  extends BaseInteractor {
    private UserManageRepository userManageRepository;
    private String mobile;
    private String smsCode;

    @Inject
    public LoginInteractorImpl(UserManageRepository userManageRepository, ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread,String mobile,String smsCode) {
        super(threadExecutor,postExecutionThread);
        this.userManageRepository = userManageRepository;
        this.mobile = mobile;
        this.smsCode = smsCode;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userManageRepository.login(mobile,smsCode);
    }
}
