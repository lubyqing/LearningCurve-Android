package com.arthas.learningcurve.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.anton46.stepsview.StepsView;
import com.arthas.learningcurve.R;

/**
 * Created by Tcz on 16/4/12.
 */
public class TabThreeFragment extends BaseFragment {
    @Bind(R.id.view_step)
    StepsView mStepView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.tab_three_layout, null);
        ButterKnife.bind(this, view);

        mStepView.setLabels(new String[]{"step1", "step2", "step3", "step4"})
                 .setBarColorIndicator(getContext().getResources()
                                                   .getColor(R.color.material_blue_grey_800))
                 .setProgressColorIndicator(getContext().getResources()
                                                        .getColor(R.color.orange))
                 .setLabelColorIndicator(getContext().getResources()
                                                     .getColor(R.color.orange))
                 .setCompletedPosition(0)
                .drawView();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
