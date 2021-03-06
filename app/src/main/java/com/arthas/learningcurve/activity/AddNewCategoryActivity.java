package com.arthas.learningcurve.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.injection.component.AddCategoryComponent;
import com.arthas.learningcurve.injection.component.DaggerAddCategoryComponent;
import com.arthas.learningcurve.injection.module.AddCategoryModule;
import com.arthas.learningcurve.interfaceview.AddCategoryView;
import com.arthas.learningcurve.model.CategoryTreeModel;
import com.arthas.learningcurve.presenter.AddCategoryPresenter;
import com.arthas.learningcurve.widget.BaseProgressDialog;
import com.arthas.learningcurve.widget.ClearEditText;
import com.arthas.learningcurve.widget.thirdpart.labelview.LabelTextView;
import com.cunoraz.tagview.OnTagClickListener;
import com.cunoraz.tagview.Tag;
import com.cunoraz.tagview.TagView;
import com.github.johnkil.print.PrintView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tcz on 16/4/18.
 */
public class AddNewCategoryActivity extends BaseActivity implements AddCategoryView {
    @Bind(R.id.view_tag)
    TagView mTagView;
    @Bind(R.id.tv_label_dark_gray)
    LabelTextView mDarkGrayLabelTv;
    @Bind(R.id.tv_label_blue)
    LabelTextView mBlueLabelTv;
    @Bind(R.id.tv_label_green)
    LabelTextView mGreenLabelTv;
    @Bind(R.id.tv_label_gray)
    LabelTextView mGrayLabelTv;
    @Bind(R.id.tv_label_yellow)
    LabelTextView mYellowLabelTv;
    @Bind(R.id.pv_node_icon)
    PrintView mNodeIconPv;
    @Bind(R.id.ll_icon_container)
    LinearLayout mIconContainer;
    @Bind(R.id.et_category_name)
    ClearEditText mCategoryNameEt;
    @Bind(R.id.btn_add_category)
    Button mAddCategoryBtn;


    @Inject
    AddCategoryPresenter mAddCategoryPresenter;

    private BaseProgressDialog mProgressDialog;

    private AddCategoryComponent mAddCategoryComponent;

    private Tag mClickTag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_category);
        ButterKnife.bind(this);

        initLabelView();
        initDefaultCategory();

        mProgressDialog = BaseProgressDialog.createDialog(this);

        this.mAddCategoryComponent = DaggerAddCategoryComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .addCategoryModule(new AddCategoryModule())
                .build();
        mAddCategoryComponent.inject(this);

        mAddCategoryPresenter.setView(this);
    }

    private void initLabelView() {
        mDarkGrayLabelTv.setLabelVisual(true);
        mDarkGrayLabelTv.setLabelText(getString(R.string.label_default_text));
    }

    private void initDefaultCategory() {
        String[] defaultCategorys = getResources().getStringArray(R.array.category_default);
        List<Tag> tagList = new ArrayList<>(defaultCategorys.length);
        Tag tag;
        for (String category : defaultCategorys) {
            tag = new Tag(category);
            tag.background = getResources().getDrawable(R.drawable.label_green_selector);
            tagList.add(tag);
        }
        mTagView.addTags(tagList);

        mTagView.setOnTagClickListener(new OnTagClickListener() {
            @Override
            public void onTagClick(Tag tag, int position) {
                mClickTag = tag;
                mAddCategoryPresenter.addCateogry(true);
            }
        });
    }

    @OnClick({R.id.tv_label_dark_gray,
            R.id.tv_label_blue,
            R.id.tv_label_green,
            R.id.tv_label_gray,
            R.id.tv_label_yellow,
            R.id.ll_icon_container,
            R.id.btn_add_category})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_label_dark_gray:
            case R.id.tv_label_blue:
            case R.id.tv_label_green:
            case R.id.tv_label_gray:
            case R.id.tv_label_yellow:
                updateLabelVisibility(view.getId());
                updateIconFontColor(view.getId());
                break;
            case R.id.ll_icon_container:
                startActivity(getStartOnNewIntent(IconFontActivity.class));
                overridePendingTransition(R.anim.push_bottom_in, 0);
                break;
            case R.id.btn_add_category:
                if (TextUtils.isEmpty(mCategoryNameEt.getText())) {
                    showToast("请输入分类名称");
                    return;
                }
                mAddCategoryPresenter.addCateogry(false);
                break;
        }
    }

    /**
     * refresh label view visible
     *
     * @param viewId
     */
    private void updateLabelVisibility(int viewId) {
        mDarkGrayLabelTv.setLabelText(getString(R.string.label_selected_text));
        mDarkGrayLabelTv.setLabelVisual(viewId == R.id.tv_label_dark_gray);
        mBlueLabelTv.setLabelVisual(viewId == R.id.tv_label_blue);
        mGreenLabelTv.setLabelVisual(viewId == R.id.tv_label_green);
        mGrayLabelTv.setLabelVisual(viewId == R.id.tv_label_gray);
        mYellowLabelTv.setLabelVisual(viewId == R.id.tv_label_yellow);
    }

    /**
     * refresh font icon color by select color
     *
     * @param viewId
     */
    private void updateIconFontColor(int viewId) {
        ColorDrawable drawable = (ColorDrawable) findViewById(viewId).getBackground();
        mNodeIconPv.setIconColor(drawable.getColor());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && (!TextUtils.isEmpty(intent.getStringExtra(Constant.KEY_ICON_FONT)))) {
            mNodeIconPv.setIconText(intent.getStringExtra(Constant.KEY_ICON_FONT));
        }

    }

    @Override
    public CharSequence getIconFont() {
        return mNodeIconPv.getIconText();
    }

    @Override
    public Integer getIconColor() {
        return mNodeIconPv.getIconColor().getDefaultColor();
    }

    @Override
    public CharSequence getCategoryName() {
        return mCategoryNameEt.getText();
    }

    @Override
    public String getTagText() {
        return mClickTag == null ?null:mClickTag.text;
    }

    @Override
    public void onAddSuccessed(CategoryTreeModel model) {
        if (model == null){
            showToast("添加分类失败");
        }else{
            Intent intent = getBackOnNewIntent();
            intent.putExtra("model", (Serializable) model);
            startActivity(intent);
            finish();
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
