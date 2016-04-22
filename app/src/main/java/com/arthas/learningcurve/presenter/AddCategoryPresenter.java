package com.arthas.learningcurve.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.arthas.learningcurve.R;
import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.common.ResultCode;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.interactor.DefaultSubscriber;
import com.arthas.learningcurve.interactor.impl.AddCategoryInteractorImpl;
import com.arthas.learningcurve.interactor.impl.LoginInteractorImpl;
import com.arthas.learningcurve.interactor.impl.SmsInteractorImpl;
import com.arthas.learningcurve.interfaceview.AddCategoryView;
import com.arthas.learningcurve.interfaceview.LoginView;
import com.arthas.learningcurve.model.CategoryTreeModel;
import com.arthas.learningcurve.model.UserInfoModel;
import com.arthas.learningcurve.utils.AppPrefsUtils;
import com.arthas.learningcurve.utils.InputValidatorUtils;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class AddCategoryPresenter {
    private AddCategoryView mAddCategoryView;

    @Inject
    Context mContext;

    @Inject
    @Named("addCategoryInteractor")
    BaseInteractor addCategoryInteractor;

    @Inject
    public AddCategoryPresenter() {
    }


    public void setView(AddCategoryView addCategoryView) {
        this.mAddCategoryView = addCategoryView;
    }


    public void addCateogry(boolean isDefault) {
        CategoryTreeModel model = new CategoryTreeModel();
        model.setIconFont(mAddCategoryView.getIconFont().toString());
        model.setParentId(0);
        model.setLevel(Constant.CategoryLevel.FIRST_LEVEL);
        model.setCategoryName(isDefault ? mAddCategoryView.getTagText() : mAddCategoryView.getCategoryName().toString());
        model.setIconColor(mAddCategoryView.getIconColor());
        mAddCategoryView.showLoading();

        ((AddCategoryInteractorImpl) addCategoryInteractor).setCategoryTreeModel(model);
        addCategoryInteractor.execute(new DefaultSubscriber<CategoryTreeModel>() {
            @Override
            public void onNext(CategoryTreeModel model) {
                mAddCategoryView.onAddSuccessed(model);
            }

            @Override
            public void onCompleted() {
                mAddCategoryView.dismissLoading();
            }

            @Override
            public void onError(Throwable e) {
                mAddCategoryView.dismissLoading();
            }
        });

    }


}
