package com.arthas.learningcurve.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.widget.thirdpart.BadgeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tcz on 16/4/12.
 */
public class TabCenterFragment extends BaseFragment {

    @Bind(R.id.tv_category)
    TextView mCategoryTv;
    @Bind(R.id.tv_recent_plan)
    TextView mRecentPlanTv;
    @Bind(R.id.tv_completed_plan)
    TextView mCompletedPlanTv;
    @Bind(R.id.tv_overdue_plan)
    TextView mOverduePlanTv;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BadgeView badgeView = new BadgeView(getActivity(),mCategoryTv);
        badgeView.setText("2");
        badgeView.toggle();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv_category, R.id.tv_recent_plan, R.id.tv_completed_plan, R.id.tv_overdue_plan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_category:
                break;
            case R.id.tv_recent_plan:
                break;
            case R.id.tv_completed_plan:
                break;
            case R.id.tv_overdue_plan:
                break;
        }
    }
}
