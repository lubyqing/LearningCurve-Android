package com.arthas.learningcurve.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.adapter.holder.*;
import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.injection.component.DaggerAddCategoryComponent;
import com.arthas.learningcurve.injection.component.DaggerGetCategoryComponent;
import com.arthas.learningcurve.injection.component.GetCategoryComponent;
import com.arthas.learningcurve.injection.module.AddCategoryModule;
import com.arthas.learningcurve.injection.module.GetCategoryModule;
import com.arthas.learningcurve.interfaceview.GetAllCategoryView;
import com.arthas.learningcurve.model.CategoryTreeModel;
import com.arthas.learningcurve.presenter.GetCategoryPresenter;
import com.arthas.learningcurve.widget.BaseProgressDialog;
import com.arthas.learningcurve.widget.HeaderBar;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tcz on 16/4/18.
 */
public class MyCategoryActivity extends BaseActivity implements GetAllCategoryView {
    @Bind(R.id.header_bar)
    HeaderBar mHeaderBar;
    @Bind(R.id.container)
    FrameLayout mContainerView;

    private TreeNode mRootTreeNode;
    private List<CategoryTreeModel> categoryModelList;
    AndroidTreeView mTreeView;

    @Inject
    GetCategoryPresenter mGetCategoryPresenter;

    private BaseProgressDialog mProgressDialog;

    private GetCategoryComponent mGetCategoryComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_category);
        ButterKnife.bind(this);

        mProgressDialog = BaseProgressDialog.createDialog(this);
        mHeaderBar.setOnHeaderBtnClickedListener(this);

        initViewData();

        this.mGetCategoryComponent = DaggerGetCategoryComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .getCategoryModule(new GetCategoryModule())
                .build();
        mGetCategoryComponent.inject(this);

        mGetCategoryPresenter.setView(this);

        mGetCategoryPresenter.getCateogry();
    }


    private void initViewData() {
        mRootTreeNode = TreeNode.root();

        initTreeNode(mRootTreeNode, categoryModelList);

        mTreeView = new AndroidTreeView(this, mRootTreeNode);
        mTreeView.setDefaultAnimation(true);
        mTreeView.setDefaultContainerStyle(R.style.TreeNodeStyleDivided, true);
        mContainerView.addView(mTreeView.getView());
    }

    private void initTreeNode(TreeNode parentNode, List<CategoryTreeModel> list) {
        if (list != null && list.size() > 0) {
            for (CategoryTreeModel model : list) {
                TreeNode treeNode = generateTreeNode(model);

                initTreeNode(treeNode, model.getChildList());

                parentNode.addChildren(treeNode);
            }
        }
    }

    private TreeNode generateTreeNode(CategoryTreeModel model) {
        TreeNode tempTreeNode = new TreeNode(model);
        switch (model.getLevel()) {
            case Constant.CategoryLevel.FIRST_LEVEL:
                tempTreeNode.setViewHolder(
                        new FirstLevelHolder(this));
                break;
            case Constant.CategoryLevel.SECOND_LEVEL:
                tempTreeNode.setViewHolder(
                        new SecondLevelHolder(this));
                break;
            case Constant.CategoryLevel.THIRD_LEVEL:
                tempTreeNode.setViewHolder(
                        new ThirdLevelHolder(this));
                break;

        }

        return tempTreeNode;
    }

    @Override
    public void onHeaderRightClicked() {
        startActivity(getStartOnNewIntent(AddNewCategoryActivity.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent != null) {
            CategoryTreeModel model = (CategoryTreeModel) intent.getSerializableExtra("model");
            categoryModelList.add(model);

            mTreeView.addNode(mRootTreeNode, new TreeNode(model).setViewHolder(
                    new FirstLevelHolder(this)));
        }

    }

    @Override
    public void onGetSuccessed(List<CategoryTreeModel> treeList) {
        categoryModelList = treeList;
        if (categoryModelList != null && categoryModelList.size() > 0){
            for (CategoryTreeModel model : categoryModelList){
                mTreeView.addNode(mRootTreeNode, new TreeNode(model).setViewHolder(
                        new FirstLevelHolder(this)));
            }
        }
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void dismissLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showErrorMsg(int errorId) {
        showToast(errorId);
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        showToast(errorMsg);
    }
}
