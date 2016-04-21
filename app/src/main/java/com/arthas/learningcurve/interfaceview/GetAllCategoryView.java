package com.arthas.learningcurve.interfaceview;

import com.arthas.learningcurve.model.CategoryTreeModel;

import java.util.List;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface GetAllCategoryView extends BaseView{

    void onGetSuccessed(List<CategoryTreeModel> treeList);




}
