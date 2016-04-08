package com.arthas.learningcurve;

import com.diligrp.mobsite.getway.domain.GetDicsReq;
import com.diligrp.mobsite.getway.domain.GetDicsResp;
import com.diligrp.mobsite.getway.domain.protocol.BaseResp;
import com.diligrp.mobsite.getway.domain.protocol.common.GetAgreementUrlReq;
import com.diligrp.mobsite.getway.domain.protocol.common.GetAgreementUrlResp;
import com.diligrp.mobsite.getway.domain.protocol.common.GetCityReq;
import com.diligrp.mobsite.getway.domain.protocol.common.GetCityResp;
import com.diligrp.mobsite.getway.domain.protocol.common.GetNoticeResp;
import com.diligrp.mobsite.getway.domain.protocol.common.GetSystemConfigReq;
import com.diligrp.mobsite.getway.domain.protocol.common.GetSystemConfigResp;
import com.diligrp.mobsite.getway.domain.protocol.common.GetUnitInfoReq;
import com.diligrp.mobsite.getway.domain.protocol.common.GetUnitInfoResp;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


public interface CommonService {
    @POST("/mobsiteApp/common/getAgreementUrl.do")
    Observable<GetAgreementUrlResp> getAgreementUrl(@Body GetAgreementUrlReq request);

    @POST("/mobsiteApp/common/getCity.do")
    Observable<GetCityResp> getCity(@Body GetCityReq request);

    @POST("/mobsiteApp/common/getCountry.do")
    Observable<GetCityResp> getCountry(@Body GetCityReq request);

    @POST("/mobsiteApp/common/getDics.do")
    Observable<GetDicsResp> getDics(@Body GetDicsReq request);

    @POST("/mobsiteApp/common/getNotice.do")
    Observable<GetNoticeResp> getNotice(@Body BaseResp request);

    @POST("/mobsiteApp/common/getSystemConfig.do")
    Observable<GetSystemConfigResp> getSystemConfig(@Body GetSystemConfigReq request);

    @POST("/mobsiteApp/common/getUnitInfo.do")
    Observable<GetUnitInfoResp> getUnitInfo(@Body GetUnitInfoReq request);

//    TODO Finish this multipart
//    @Multipart
//    @POST("/mobsiteApp/common/uploadAudio.do")
//    Observable<UploadAudioResp> uploadAudio(@Body UploadAudioReq request);

//    TODO Finish this multipart
//    @Multipart
//    @POST("/mobsiteApp/common/uploadImg.do")
//    Observable<UploadImgResp> uploadImg(@Body UploadImgReq request);

//    TODO Finish this multipart
//    @Multipart
//    @POST("/mobsiteApp/common/uploadImgFullUrl.do")
//    Observable<UploadImgFullUrlResp> uploadImgFullUrl(@Body UploadImgFullUrlReq request);

}
