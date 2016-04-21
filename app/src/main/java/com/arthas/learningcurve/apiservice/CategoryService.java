package com.arthas.learningcurve.apiservice;

import com.arthas.learningcurve.domain.AddCategoryReq;
import com.arthas.learningcurve.domain.AddCategoryResp;
import com.arthas.learningcurve.domain.BaseReq;
import com.arthas.learningcurve.domain.BaseResp;
import com.arthas.learningcurve.domain.GetCategoryResp;
import com.arthas.learningcurve.domain.GetCateoryReq;
import com.arthas.learningcurve.domain.LoginReq;
import com.arthas.learningcurve.domain.LoginResp;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface CategoryService {
    @POST("category/addCategory")
    Observable<AddCategoryResp> addCategory(@Body AddCategoryReq request);

    @POST("category/getAllCategory")
    Observable<GetCategoryResp> getAllCategory(@Body GetCateoryReq request);


}
