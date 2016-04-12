package com.arthas.learningcurve.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.arthas.learningcurve.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class BottomNavigator extends FrameLayout implements OnClickListener {
    public static final int TAB1_TAG = 0x01;
    public static final int TAB2_TAG = 0x02;
    public static final int TAB3_TAG = 0x03;
    public static final int TAB4_TAG = 0x04;
    public static final int TAB_CENTER_TAG = 0x05;


    private Context mContext;
    
//    @Bind(R.id.tv_tab1)
     TextView mTab1Tv;
//    @Bind(R.id.tv_tab2)
     TextView mTab2Tv;
//    @Bind(R.id.tv_tab3)
     TextView mTab3Tv;
//    @Bind(R.id.tv_tab4)
     TextView mTab4Tv;
//    @Bind(R.id.iv_center_tab)
    ImageView mCenterTabIv;

    
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

        mTab1Tv = (TextView) layout.findViewById(R.id.tv_tab1);
        mTab2Tv = (TextView) layout.findViewById(R.id.tv_tab2);
        mTab3Tv = (TextView) layout.findViewById(R.id.tv_tab3);
        mTab4Tv = (TextView) layout.findViewById(R.id.tv_tab4);
        mCenterTabIv = (ImageView) layout.findViewById(R.id.iv_center_tab);



        mTab1Tv.setTag(TAB1_TAG);
        mTab2Tv.setTag(TAB2_TAG);
        mTab3Tv.setTag(TAB3_TAG);
        mTab4Tv.setTag(TAB4_TAG);
        mCenterTabIv.setTag(TAB_CENTER_TAG);

        mTab1Tv.setOnClickListener(this);
        mTab2Tv.setOnClickListener(this);
        mTab3Tv.setOnClickListener(this);
        mTab4Tv.setOnClickListener(this);
        mCenterTabIv.setOnClickListener(this);

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
}
