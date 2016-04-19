package com.arthas.learningcurve.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.adapter.holder.*;
import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.model.CategoryModel;
import com.arthas.learningcurve.widget.HeaderBar;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tcz on 16/4/18.
 */
public class MyCategoryActivity extends BaseActivity {
    @Bind(R.id.header_bar)
    HeaderBar mHeaderBar;
    @Bind(R.id.container)
    FrameLayout mContainerView;

    private TreeNode mRootTreeNode;
    private List<CategoryModel> categoryModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_category);
        ButterKnife.bind(this);

        mHeaderBar.setOnHeaderBtnClickedListener(this);

        initTestData();
        initViewData();

    }


    private void initTestData() {
        categoryModelList = new ArrayList<>();

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setIcon(getString(R.string.ic_folder));
        categoryModel.setCategoryName("English");
        categoryModel.setLevel(Constant.CategoryLevel.FIRST_LEVEL);

        List<CategoryModel> childList = new ArrayList<>();
        CategoryModel cet4 = new CategoryModel();
        cet4.setIcon(getString(R.string.ic_folder_shared));
        cet4.setCategoryName("CET4");
        cet4.setLevel(categoryModel.getLevel() + 1);

        List<CategoryModel> childList1 = new ArrayList<>();
        CategoryModel child1 = new CategoryModel();
        child1.setLevel(3);
        child1.setCategoryName("60 score");
        child1.setIcon(getString(R.string.ic_folder_mydrive));
        childList1.add(child1);
        cet4.setChildCategoryList(childList1);
        CategoryModel cet6 = new CategoryModel();
        cet6.setIcon(getString(R.string.ic_folder_shared));
        cet6.setCategoryName("CET6");
        cet6.setLevel(categoryModel.getLevel() + 1);
        childList.add(cet4);
        childList.add(cet6);
        categoryModel.setChildCategoryList(childList);


        CategoryModel categoryModel1 = new CategoryModel();
        categoryModel1.setIcon(getString(R.string.ic_folder));
        categoryModel1.setCategoryName("Program");
        categoryModel1.setLevel(Constant.CategoryLevel.FIRST_LEVEL);

        categoryModelList.add(categoryModel);
        categoryModelList.add(categoryModel1);
    }

    private void initViewData() {
        mRootTreeNode = TreeNode.root();

        generateTreeView(mRootTreeNode, categoryModelList);

        AndroidTreeView mTreeView = new AndroidTreeView(this, mRootTreeNode);
        mTreeView.setDefaultAnimation(true);
        mTreeView.setDefaultContainerStyle(R.style.TreeNodeStyleDivided, true);
        mContainerView.addView(mTreeView.getView());
    }

    private void generateTreeView(TreeNode parentNode, List<CategoryModel> list) {
        if (list != null && list.size() > 0) {
            for (CategoryModel model : list) {
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
                generateTreeView(tempTreeNode, model.getChildCategoryList());

                parentNode.addChildren(tempTreeNode);
            }
        }
    }

    @Override
    public void onHeaderRightClicked() {
        startActivity(AddNewCategoryActivity.class);
    }

    private void addProfileData(TreeNode profile, List<CategoryModel> childList) {

        if (childList != null && childList.size() > 0) {
            for (CategoryModel model : childList) {
                TreeNode
                        socialNetworks =
                        new TreeNode(model).setViewHolder(
                                new SecondLevelHolder(this));
                profile.addChildren(socialNetworks);
            }
        }
    }
}
