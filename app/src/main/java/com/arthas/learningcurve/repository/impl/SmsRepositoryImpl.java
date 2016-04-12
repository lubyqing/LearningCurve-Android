package com.arthas.learningcurve.repository.impl;

import android.util.Log;

import com.arthas.learningcurve.apiservice.SmsService;
import com.arthas.learningcurve.apiservice.factory.RetrofitBuilderFactory;
import com.arthas.learningcurve.domain.GetLoginSmsReq;
import com.arthas.learningcurve.repository.SmsRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by tanchuanzhi on 16/3/29.
 */
public class SmsRepositoryImpl implements SmsRepository {

    @Inject
    public SmsRepositoryImpl() {
    }

    @Override
    public Observable<String> sendSmsVerifyCode(String mobile) {

        GetLoginSmsReq req = new GetLoginSmsReq();
        req.setMobile(mobile);
        return RetrofitBuilderFactory.create().build().create(SmsService.class).getLoginSms(
               req).map(resp -> {
            if(resp == null
                    || resp.getCode() != 0){


            }
            return "resp code = "+resp.getCode() + ","+resp.getMessage();
        });

    }


}
