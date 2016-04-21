package com.arthas.learningcurve.interactor.impl;

import com.arthas.learningcurve.domain.CategoryTree;
import com.arthas.learningcurve.domain.GetCateoryReq;
import com.arthas.learningcurve.executor.PostExecutionThread;
import com.arthas.learningcurve.executor.ThreadExecutor;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.model.CategoryTreeModel;
import com.arthas.learningcurve.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class GetCategoryInteractorImpl extends BaseInteractor {
    private CategoryRepository categoryRepository;


    @Inject
    public GetCategoryInteractorImpl(CategoryRepository categoryRepository, ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread) {
        super(threadExecutor,postExecutionThread);
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        GetCateoryReq req  = new GetCateoryReq();
        return categoryRepository.getAllCategory(req).map(resp -> {
            List<CategoryTree> serverList = resp.getCategoryTree();
            List<CategoryTreeModel> localList = null;
            if(serverList != null && serverList.size() > 0){
                localList = new ArrayList<>(serverList.size());
                CategoryTreeModel categoryTreeModel = null;
                for (CategoryTree categoryTree : serverList){
                    categoryTreeModel = new CategoryTreeModel();
                    categoryTreeModel.setCategoryName(categoryTree.getCategoryName());
                    categoryTreeModel.setIconColor(categoryTree.getIconColor());
                    categoryTreeModel.setIconFont(categoryTree.getIconFont());
                    categoryTreeModel.setLevel(categoryTree.getLevel());
                    categoryTreeModel.setId(categoryTree.getId());
                    categoryTreeModel.setParentId(categoryTree.getParentId());
                    localList.add(categoryTreeModel);
                }
            }

            return localList;
        });
    }
}
