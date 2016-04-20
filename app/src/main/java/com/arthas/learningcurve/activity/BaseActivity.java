package com.arthas.learningcurve.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.arthas.learningcurve.base.AppManager;
import com.arthas.learningcurve.base.BaseApplication;
import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.injection.component.ApplicationComponent;
import com.arthas.learningcurve.injection.module.ActivityModule;
import com.arthas.learningcurve.utils.ToastUtils;
import com.arthas.learningcurve.widget.HeaderBar;

/**
 * 窗口基类
 * 
 */
@SuppressLint("NewApi")
public class BaseActivity extends FragmentActivity implements HeaderBar.OnHeaderBtnClickedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
        this.getApplicationComponent().inject(this);
    }


    /**
     * 以无参数的模式启动Activity。
     * 
     * @param activityClass
     */
    public void startActivity(Class<? extends Activity> activityClass) {
        startActivity(getLocalIntent(activityClass, null));
     //   me.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
    
    /**
     * 以绑定参数的模式启动Activity。
     * 
     * @param activityClass
     */
    public void startActivity(Class<? extends Activity> activityClass, Bundle bd) {
        startActivity(getLocalIntent(activityClass, bd));
    //    me.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
    
    /**
     * 在底部显示一条toast信息,大约3秒钟时间。<br>
     * 若想让toast显示时间较长，请调用showLongMessage
     * 
     * @param msg
     */
    public void showMessage(Object msg) {
        Toast.makeText(this, msg + "", Toast.LENGTH_SHORT).show();
    }
    
    /**
     * 以较长的时间来toast显示，大约5秒钟显示。
     * 
     * @param msg
     */
    public void showLongMessage(String msg) {
        ToastUtils.showLongMessage(this, msg);
    }
    
    /**
     * 显示消息提示，避免重复提示
     * 
     * @param msg
     */
    public void showToast(String msg) {
        ToastUtils.showShortMessage(this, msg);
    }

    public void showToast(int msgId){
        ToastUtils.showLongMessage(this,msgId);
    }

    @Override
    protected void onDestroy() {
        AppManager.getAppManager().finishActivity(this);

        super.onDestroy();
    }

    /**
     * 获取当前程序中的本地目标
     *
     * @param localIntent
     * @return
     */
    public Intent getLocalIntent(Class<? extends Context> localIntent, Bundle bd) {
        Intent intent = new Intent(this, localIntent);
        if (null != bd) {
            intent.putExtras(bd);
        }
        return intent;
    }
    /**
     * Get the Main Application component for dependency injection.
     *
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((BaseApplication)getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public void onHeaderLeftClicked() {
        this.finish();
    }

    @Override
    public void onHeaderTitleClicked() {

    }

    @Override
    public void onHeaderRightClicked() {

    }

    protected Intent getBackOnNewIntent(){
        Intent intent = getIntent();
        try {
            intent.setClass(this, Class.forName(intent.getStringExtra(Constant.KEY_CLASS_NAME)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    protected Intent getStartOnNewIntent(Class activityClass){
        Intent intent = new Intent();
        intent.setClass(this, activityClass);
        intent.putExtra(Constant.KEY_CLASS_NAME, this.getClass().getName());
        return intent;
    }
}
