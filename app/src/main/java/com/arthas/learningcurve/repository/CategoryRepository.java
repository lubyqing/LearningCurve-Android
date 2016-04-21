package com.arthas.learningcurve.repository;

import com.arthas.learningcurve.domain.AddCategoryReq;
import com.arthas.learningcurve.domain.AddCategoryResp;
import com.arthas.learningcurve.domain.GetCategoryResp;
import com.arthas.learningcurve.domain.GetCateoryReq;
import com.arthas.learningcurve.domain.LoginReq;
import com.arthas.learningcurve.domain.LoginResp;

import rx.Observable;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface CategoryRepository {
    Observable<AddCategoryResp> addCategory(AddCategoryReq req);

    Observable<GetCategoryResp> getAllCategory(GetCateoryReq req);
}
