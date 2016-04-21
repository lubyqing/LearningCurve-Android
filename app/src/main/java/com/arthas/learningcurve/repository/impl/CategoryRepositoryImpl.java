package com.arthas.learningcurve.repository.impl;

import com.arthas.learningcurve.apiservice.CategoryService;
import com.arthas.learningcurve.apiservice.UserManageService;
import com.arthas.learningcurve.apiservice.factory.RetrofitBuilderFactory;
import com.arthas.learningcurve.domain.AddCategoryReq;
import com.arthas.learningcurve.domain.AddCategoryResp;
import com.arthas.learningcurve.domain.GetCategoryResp;
import com.arthas.learningcurve.domain.GetCateoryReq;
import com.arthas.learningcurve.domain.LoginReq;
import com.arthas.learningcurve.domain.LoginResp;
import com.arthas.learningcurve.repository.CategoryRepository;
import com.arthas.learningcurve.repository.UserManageRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class CategoryRepositoryImpl implements CategoryRepository {

    @Inject
    public CategoryRepositoryImpl() {
    }

    @Override
    public Observable<AddCategoryResp> addCategory(AddCategoryReq req) {
        return RetrofitBuilderFactory.create()
                                     .build()
                                     .create(CategoryService.class)
                                     .addCategory(req);
    }

    @Override
    public Observable<GetCategoryResp> getAllCategory(GetCateoryReq req) {
        return RetrofitBuilderFactory.create()
                .build()
                .create(CategoryService.class)
                .getAllCategory(req);
    }
}
