package com.arthas.learningcurve.apiservice;

import com.arthas.learningcurve.domain.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface SmsService {
    @POST("sms/getLoginSms")
    Observable<GetLoginSmsResp> getLoginSms(@Body GetLoginSmsReq request);

}
