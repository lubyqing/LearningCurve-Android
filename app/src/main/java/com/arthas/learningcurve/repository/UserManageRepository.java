package com.arthas.learningcurve.repository;

import com.arthas.learningcurve.domain.LoginReq;
import com.arthas.learningcurve.domain.LoginResp;

import rx.Observable;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface UserManageRepository {
    Observable<LoginResp> login(LoginReq req);
}
