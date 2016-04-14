package com.arthas.learningcurve.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.arthas.learningcurve.R;


public class SingleLineText extends FrameLayout {

    TextView mLabelTv;
    TextView mConentTv;
    ImageView mContentIv;
    ImageView mArrowIv;
    View mBottomLineView;

    private CharSequence mLabelText;
    private boolean isShowArrow;
    private boolean isImgContent;
    private boolean isShowBottomLine;

    public SingleLineText(Context context) {
        this(context, null);
    }

    public SingleLineText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SingleLineText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.SingleLineText, defStyle, 0);

        mLabelText = typedArray
                .getText(R.styleable.SingleLineText_labelText);
        isShowArrow = typedArray.getBoolean(R.styleable.SingleLineText_isShowArrow, true);
        isImgContent = typedArray.getBoolean(R.styleable.SingleLineText_isImgContent, false);
        isShowBottomLine = typedArray.getBoolean(R.styleable.SingleLineText_isShowBottomLine, true);
        init(context);
        typedArray.recycle();
    }

    private void init(Context context) {

        View rootView = LayoutInflater.from(context).inflate(
                R.layout.view_single_line_text, null);
        this.mBottomLineView = rootView.findViewById(R.id.view_bottom_line);
        this.mArrowIv = (ImageView) rootView.findViewById(R.id.iv_arrow);
        this.mContentIv = (ImageView) rootView.findViewById(R.id.iv_content);
        this.mConentTv = (TextView) rootView.findViewById(R.id.tv_content);
        this.mLabelTv = (TextView) rootView.findViewById(R.id.tv_label);

        if (!TextUtils.isEmpty(mLabelText)) {
            mLabelTv.setText(mLabelText);
        }
        mArrowIv.setVisibility(isShowArrow ? VISIBLE : GONE);
        mConentTv.setVisibility(isImgContent ? GONE : VISIBLE);
        mContentIv.setVisibility(isImgContent ? VISIBLE : GONE);
        mBottomLineView.setVisibility(isShowBottomLine ? VISIBLE : GONE);

        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        this.addView(rootView, params);
    }

}
