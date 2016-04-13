package com.arthas.learningcurve.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.arthas.learningcurve.R;
import com.arthas.learningcurve.widget.thirdpart.BadgeView;

import java.util.ArrayList;
import java.util.List;


public class BottomNavigator extends FrameLayout implements OnClickListener {
    public static final int TAB_ONE_TAG = 0x00;
    public static final int TAB_TWO_TAG = 0x01;
    public static final int TAB_THREE_TAG = 0x02;
    public static final int TAB_FOUR_TAG = 0x03;
    public static final int TAB_CENTER_TAG = 0x04;


    private Context mContext;

    //    @Bind(R.id.tv_tab1)
    TextView mTabOneTv;
    //    @Bind(R.id.tv_tab2)
    TextView mTabTwoTv;
    //    @Bind(R.id.tv_tab3)
    TextView mTabThreeTv;
    //    @Bind(R.id.tv_tab4)
    TextView mTabFourTv;
    //    @Bind(R.id.iv_center_tab)
    ImageView mCenterTabIv;

    private List<View> mTabViewList;

    private BadgeView mMsgBadgeView;


    public BottomNavigator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public BottomNavigator(Context context) {
        super(context);
        mContext = context;
        init();
    }

    @SuppressLint("InflateParams")
    private void init() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.bottom_navigator, null);
//        ButterKnife.bind(layout);

        mTabOneTv = (TextView) layout.findViewById(R.id.tv_tab_one);
        mTabTwoTv = (TextView) layout.findViewById(R.id.tv_tab_two);
        mTabThreeTv = (TextView) layout.findViewById(R.id.tv_tab_three);
        mTabFourTv = (TextView) layout.findViewById(R.id.tv_tab_four);
        mCenterTabIv = (ImageView) layout.findViewById(R.id.iv_center_tab);

        mTabOneTv.setTag(TAB_ONE_TAG);
        mTabTwoTv.setTag(TAB_TWO_TAG);
        mTabThreeTv.setTag(TAB_THREE_TAG);
        mTabFourTv.setTag(TAB_FOUR_TAG);
        mCenterTabIv.setTag(TAB_CENTER_TAG);

        mTabOneTv.setOnClickListener(this);
        mTabTwoTv.setOnClickListener(this);
        mTabThreeTv.setOnClickListener(this);
        mTabFourTv.setOnClickListener(this);
        mCenterTabIv.setOnClickListener(this);

        mTabViewList = new ArrayList<View>();
        mTabViewList.add(mTabOneTv);
        mTabViewList.add(mTabTwoTv);
        mTabViewList.add(mTabThreeTv);
        mTabViewList.add(mTabFourTv);
        mTabViewList.add(mCenterTabIv);

//        mMsgBadgeView = new BadgeView(mContext,mTabThreeTv);
//        mMsgBadgeView.setText("3");
//        mMsgBadgeView.setGravity(Gravity.BOTTOM|Gravity.RIGHT);
//        mMsgBadgeView.show();


        this.addView(layout);

    }

    @Override
    public void onClick(View v) {
        onItemChangedListener.onItemChanged((Integer) v.getTag());
    }

    public interface OnItemChangedListener {
        void onItemChanged(int index);
    }

    private OnItemChangedListener onItemChangedListener;

    public void setOnItemChangedListener(OnItemChangedListener onItemChangedListener) {
        this.onItemChangedListener = onItemChangedListener;
    }

    public void updateSelectState(int index) {
        for (View view :mTabViewList){
            view.setSelected(false);
        }

        mTabViewList.get(index).setSelected(true);
    }
}
