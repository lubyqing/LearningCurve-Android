package com.arthas.learningcurve.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arthas.learningcurve.R;

/**
 * header bar
 *
 * @author ipangy
 */
public class HeaderBar extends RelativeLayout implements View.OnClickListener {
    private CharSequence mTitle = "";
    private boolean isTitleClickable = false;
    private boolean isShowBack = true;
    private CharSequence mRightText;

    private TextView mLeftBtn;
    private TextView mTitleTxt;
    private TextView mRightTv;

    private OnHeaderBtnClickedListener mOnHeaderBtnClickedListener;

    public HeaderBar(Context context) {
        super(context);
        init(context);
    }

    public HeaderBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.headerBarStyle);
    }

    public HeaderBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.HeaderBar, defStyle, 0);
        mTitle = a.getText(R.styleable.HeaderBar_headerTitle);
        isTitleClickable = a
                .getBoolean(
                        R.styleable.HeaderBar_headerTitleClickable,
                        true);
        isShowBack = a.getBoolean(R.styleable.HeaderBar_showBack,
                true);
        mRightText = a
                .getText(R.styleable.HeaderBar_headerRightText);

        init(context);
        a.recycle();
    }

    @SuppressLint("InflateParams")
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.header_bar, this, true);
        mLeftBtn = (TextView) layout.findViewById(R.id.tv_headerbar_left);
        mLeftBtn.setOnClickListener(this);


        setLeftBtnVisibility(isShowBack);
        mTitleTxt = (TextView) layout.findViewById(R.id.tv_headerbar_title);
        mTitleTxt.setVisibility(View.VISIBLE);
        mTitleTxt.setText(mTitle);
        if (isTitleClickable) {
            // layout.findViewById(R.id.ll_title_container).setOnClickListener(this);
            mTitleTxt.setOnClickListener(this);
        }

        mRightTv = (TextView) layout.findViewById(R.id.tv_right_text);
        if (!TextUtils.isEmpty(mRightText)){
            mRightTv.setVisibility(VISIBLE);
            mRightTv.setText(mRightText);
        }
    }


    public void setLeftBtnVisibility(boolean isVisibility) {
        mLeftBtn.setVisibility(isVisibility ? View.VISIBLE : GONE);
    }

    public void setCenterTextDrawable(int sourceId, int roate) {
        Drawable drawable = getContext().getResources().getDrawable(sourceId);
        if (roate != 0) {
            Bitmap bmpOriginal = BitmapFactory.decodeResource(
                    this.getResources(), sourceId);
            Bitmap bmResult = Bitmap.createBitmap(bmpOriginal.getWidth(),
                    bmpOriginal.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas tempCanvas = new Canvas(bmResult);
            tempCanvas.rotate(180, bmpOriginal.getWidth() / 2,
                    bmpOriginal.getHeight() / 2);
            tempCanvas.drawBitmap(bmpOriginal, 0, 0, null);
            drawable = new BitmapDrawable(getResources(), bmResult);
            bmpOriginal.recycle();
        }
        mTitleTxt.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable,
                null);
        mTitleTxt.setCompoundDrawablePadding(10);
    }

    /**
     * 设置左侧按钮的点击事件
     *
     * @param ocl
     */
    public void setBackLeftBtnClickListener(View.OnClickListener ocl) {
        this.mLeftBtn.setOnClickListener(ocl);
    }


    /**
     * 设置左侧按钮图片
     *
     * @param resId
     */
    public void setBackLeftBtnIcon(int resId) {
        Drawable left = getResources().getDrawable(resId);
        this.mLeftBtn.setCompoundDrawablesWithIntrinsicBounds(left, null, null, null);
    }

    /**
     * 设置title是否显示
     *
     * @param viewShow
     */
    public void setTitleCenterTxtVisible(int viewShow) {
        this.mTitleTxt.setVisibility(viewShow);
    }

    /**
     * 设置title
     *
     * @param title
     */
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            this.mTitleTxt.setVisibility(View.VISIBLE);
        }
        this.mTitleTxt.setText(title);
    }

    /**
     * 设置title
     *
     * @param resId
     */
    public void setTitle(int resId) {
        this.mTitleTxt.setText(resId);
    }


    /**
     * 隐藏 titlebar
     */
    public void hide() {
        this.setVisibility(View.GONE);
    }

    /**
     * 显示 titlebar
     */
    public void show() {
        this.setVisibility(View.VISIBLE);
    }


    public void setLeftDrawable(int resId) {
        Drawable left = getResources().getDrawable(resId);
        mLeftBtn.setCompoundDrawablesWithIntrinsicBounds(left, null, null, null);
    }

    public void setCenterTextColor(int resId) {
        mTitleTxt.setTextColor(getResources().getColor(resId));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_headerbar_left:
                if (mOnHeaderBtnClickedListener != null) {
                    mOnHeaderBtnClickedListener.onHeaderLeftClicked();
                }
                break;
            case /* R.id.ll_title_container */ R.id.tv_headerbar_title:
                if (mOnHeaderBtnClickedListener != null) {
                    mOnHeaderBtnClickedListener.onHeaderTitleClicked();
                }
                break;

        }
    }

    public interface OnHeaderBtnClickedListener {
        void onHeaderLeftClicked();

        void onHeaderTitleClicked();
    }
}
