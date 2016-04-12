package com.arthas.learningcurve.repository.impl;

import com.arthas.learningcurve.apiservice.UserManageService;
import com.arthas.learningcurve.apiservice.factory.RetrofitBuilderFactory;
import com.arthas.learningcurve.domain.LoginReq;
import com.arthas.learningcurve.repository.UserManageRepository;
import rx.Observable;

import javax.inject.Inject;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class UserManageRepositoryImpl implements UserManageRepository {

    @Inject
    public UserManageRepositoryImpl() {
    }

    @Override
    public Observable<String> login(String mobile, String verifyCode) {
        LoginReq req = new LoginReq();
        req.setMobile(mobile);
        req.setSmsCode(verifyCode);
        return RetrofitBuilderFactory.create()
                                     .build()
                                     .create(UserManageService.class)
                                     .login(req)
                                     .map(resp -> resp.getMessage());
    }
}
