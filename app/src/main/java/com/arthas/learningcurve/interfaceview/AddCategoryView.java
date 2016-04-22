package com.arthas.learningcurve.interfaceview;

import com.arthas.learningcurve.model.CategoryTreeModel;
import com.arthas.learningcurve.model.UserInfoModel;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface AddCategoryView extends BaseView{

    CharSequence getIconFont();
    Integer getIconColor();
    CharSequence getCategoryName();
    String getTagText();

    void onAddSuccessed(CategoryTreeModel model);




}
