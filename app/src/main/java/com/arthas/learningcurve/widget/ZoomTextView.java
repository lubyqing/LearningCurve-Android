package com.arthas.learningcurve.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.arthas.learningcurve.R;

/**
 * Created by Tcz on 16/4/18.
 */
public class ZoomTextView extends TextView {

    private boolean state;

    // 指纹
    private Bitmap fingerBitmap;

    public ZoomTextView(Context context) {
        super(context);
    }

    public ZoomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        fingerBitmap = ZoomOut(BitmapFactory.decodeResource(getResources(),
                R.drawable.fingerprint), 180, 150);
    }

    public ZoomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (state) {
            // 手指按下时
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(24);
            Matrix matrix = new Matrix();
            matrix.postTranslate(this.getWidth() / 2 - fingerBitmap.getWidth()
                    / 2, this.getHeight() / 2 - fingerBitmap.getHeight() / 2);
            // 绘制指纹
            canvas.drawBitmap(fingerBitmap, matrix, paint);
        }

    }

    public Bitmap ZoomOut(Bitmap bitmap, int newWidth, int newHeight) {
        // 获取这个图片的宽和高
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        // 计算宽高缩放率
        float rateWidth = ((float) newWidth) / width;
        float rateHeight = ((float) newHeight) / height;
        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();
        // 缩放图片动作
        matrix.postScale(rateWidth, rateHeight);
        Bitmap zoomBitmap = Bitmap.createBitmap(bitmap, 0, 0, (int) width,
                (int) height, matrix, true);
        return zoomBitmap;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        float begin = 1.0f;
        float end = 0.95f;
        // 收缩动画
        Animation beginAnimation = new ScaleAnimation(begin, end, begin, end,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        // 伸展动画
        Animation backAnimation = new ScaleAnimation(end, begin, end, begin,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        /**
         * 设置动画持续时间和保留动画结果
         */
        beginAnimation.setDuration(200);
        beginAnimation.setFillAfter(true);
        backAnimation.setDuration(200);
        backAnimation.setFillAfter(true);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:// 手指按下时调用
                this.startAnimation(beginAnimation);
                state = true;
                // 重绘
                invalidate();
                // 触发监听
                break;
            case MotionEvent.ACTION_UP:// 手指弹起时调用
                this.startAnimation(backAnimation);
                state = false;
                invalidate();
                performClick();
                break;
            // 当手指没有弹起，而是按住滑动离开了MyImageView的区域时调用
            case MotionEvent.ACTION_CANCEL:
                this.startAnimation(backAnimation);
                state = false;
                invalidate();
                break;
            default:
                break;
        }
        // 返回true，否则ACTION_UP无响应不了
        return true;
    }
}
