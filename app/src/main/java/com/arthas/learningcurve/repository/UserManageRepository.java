package com.arthas.learningcurve.repository;

import rx.Observable;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface UserManageRepository {
    Observable<String> login(String mobile,String verifyCode);
}
