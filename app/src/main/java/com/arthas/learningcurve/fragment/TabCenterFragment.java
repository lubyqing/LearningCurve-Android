package com.arthas.learningcurve.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.activity.MyCategoryActivity;
import com.arthas.learningcurve.activity.TimeLineActivity;
import com.arthas.learningcurve.utils.ToastUtils;
import com.arthas.learningcurve.widget.HeaderBar;
import com.arthas.learningcurve.widget.ZoomTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tcz on 16/4/12.
 */
public class TabCenterFragment extends BaseFragment {

    @Bind(R.id.tv_my_category)
    ZoomTextView mCategoryTv;
    @Bind(R.id.tv_recent_plan)
    ZoomTextView mRecentPlanTv;
    @Bind(R.id.tv_completed_plan)
    ZoomTextView mCompletedPlanTv;
    @Bind(R.id.tv_overdue_plan)
    ZoomTextView mOverduePlanTv;
    @Bind(R.id.view_header_bar)
    HeaderBar mHeaderBar;
    @Bind(R.id.tv_my_plan)
    ZoomTextView mMyPlanTv;
    @Bind(R.id.tv_time_line)
    ZoomTextView mTimeLineTv;
    @Bind(R.id.tv_add_new)
    ZoomTextView mAddNewTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.tab_center_layout, null);

        ButterKnife.bind(this, rootView);

        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.tv_my_category, R.id.tv_recent_plan, R.id.tv_completed_plan, R.id.tv_overdue_plan,
            R.id.tv_my_plan, R.id.tv_time_line, R.id.tv_add_new})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.tv_my_category:
                ToastUtils.showShortMessage(getActivity(), "我的分类");
                intent.setClass(getActivity(), MyCategoryActivity.class);
                break;
            case R.id.tv_recent_plan:
                ToastUtils.showShortMessage(getActivity(), "最近计划");
                break;
            case R.id.tv_completed_plan:
                ToastUtils.showShortMessage(getActivity(), "已完成");
                break;
            case R.id.tv_overdue_plan:
                ToastUtils.showShortMessage(getActivity(), "已逾期");
                break;
            case R.id.tv_my_plan:
                break;
            case R.id.tv_time_line:
                intent.setClass(getActivity(), TimeLineActivity.class);
                break;
            case R.id.tv_add_new:
                break;
        }
        startActivity(intent);
    }


}
