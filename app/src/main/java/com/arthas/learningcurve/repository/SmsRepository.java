package com.arthas.learningcurve.repository;

import rx.Observable;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface SmsRepository {
     Observable<String> sendSmsVerifyCode(String mobile) ;
}
