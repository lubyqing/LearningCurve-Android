package com.arthas.learningcurve.presenter;

import android.content.Context;

import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.interactor.DefaultSubscriber;
import com.arthas.learningcurve.interactor.impl.AddCategoryInteractorImpl;
import com.arthas.learningcurve.interactor.impl.GetCategoryInteractorImpl;
import com.arthas.learningcurve.interfaceview.AddCategoryView;
import com.arthas.learningcurve.interfaceview.GetAllCategoryView;
import com.arthas.learningcurve.model.CategoryTreeModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class GetCategoryPresenter {
    private GetAllCategoryView mGetAllCategoryView;

    @Inject
    Context mContext;

    @Inject
    @Named("getCategoryInteractor")
    BaseInteractor getCategoryInteractor;

    @Inject
    public GetCategoryPresenter() {
    }


    public void setView(GetAllCategoryView getAllCategoryView) {
        this.mGetAllCategoryView = getAllCategoryView;
    }


    public void getCateogry() {
        mGetAllCategoryView.showLoading();

        getCategoryInteractor.execute(new DefaultSubscriber<List<CategoryTreeModel>>() {
            @Override
            public void onNext(List<CategoryTreeModel> treeList) {
                mGetAllCategoryView.onGetSuccessed(treeList);
            }

            @Override
            public void onCompleted() {
                mGetAllCategoryView.dismissLoading();
            }

            @Override
            public void onError(Throwable e) {
                mGetAllCategoryView.dismissLoading();
            }
        });

    }


}
