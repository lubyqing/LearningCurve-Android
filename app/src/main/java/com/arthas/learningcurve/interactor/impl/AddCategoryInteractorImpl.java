package com.arthas.learningcurve.interactor.impl;

import com.arthas.learningcurve.domain.AddCategoryReq;
import com.arthas.learningcurve.domain.BaseUserInfo;
import com.arthas.learningcurve.domain.CategoryTree;
import com.arthas.learningcurve.domain.LoginReq;
import com.arthas.learningcurve.executor.PostExecutionThread;
import com.arthas.learningcurve.executor.ThreadExecutor;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.model.CategoryTreeModel;
import com.arthas.learningcurve.model.Token;
import com.arthas.learningcurve.model.UserInfo;
import com.arthas.learningcurve.model.UserInfoModel;
import com.arthas.learningcurve.repository.CategoryRepository;
import com.arthas.learningcurve.repository.UserManageRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class AddCategoryInteractorImpl extends BaseInteractor {
    private CategoryRepository categoryRepository;
    private CategoryTreeModel categoryTreeModel;

    public void setCategoryTreeModel(CategoryTreeModel categoryTreeModel) {
        this.categoryTreeModel = categoryTreeModel;
    }

    @Inject
    public AddCategoryInteractorImpl(CategoryRepository categoryRepository, ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread) {
        super(threadExecutor,postExecutionThread);
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        AddCategoryReq req = new AddCategoryReq();
        CategoryTree categoryTree = new CategoryTree();
        categoryTree.setCategoryName(categoryTreeModel.getCategoryName());
        categoryTree.setIconColor(categoryTreeModel.getIconColor());
        categoryTree.setIconFont(categoryTreeModel.getIconFont());
        categoryTree.setLevel(categoryTreeModel.getLevel());
        categoryTree.setParentId(categoryTreeModel.getParentId());

        req.setCategoryTree(categoryTree);
        return categoryRepository.addCategory(req).map(resp -> resp.getMessage());
    }
}
