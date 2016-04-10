package com.arthas.learningcurve.apiservice;

import com.arthas.learningcurve.domain.BaseReq;
import com.arthas.learningcurve.domain.BaseResp;
import com.arthas.learningcurve.domain.LoginReq;
import com.arthas.learningcurve.domain.LoginResp;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface UserManageService {
    @POST("/user/login")
    Observable<LoginResp> login(@Body LoginReq request);

    @POST("/user/autoLogin")
    Observable<BaseResp> getCity(@Body BaseReq request);

    @GET("/user/login")
    Observable<LoginResp> login(@Query("mobile") String mobile,@Query("smsCode") String verifyCode);

}
