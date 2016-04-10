package com.arthas.learningcurve.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.arthas.learningcurve.injection.component.ApplicationComponent;
import com.arthas.learningcurve.injection.component.DaggerApplicationComponent;
import com.arthas.learningcurve.injection.module.ApplicationModule;

public class BaseApplication extends Application {

    public static BaseApplication mApplication;

    public static Context mApplicationContext;

    public static BaseApplication getApplication() {
        return mApplication;
    }

    public static Context getAppContext() {
        return mApplicationContext;
    }

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;
        mApplicationContext = getApplicationContext();

        initializeInjector();

        // 记录崩溃异常
        GlobalExceptionHandler ueHandler = new GlobalExceptionHandler(this);
        Thread.setDefaultUncaughtExceptionHandler(ueHandler);
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                                                              .applicationModule(new ApplicationModule(this))
                                                              .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
    @Override
    public void onLowMemory() {
    	Log.d("***", "memory_low");
    	super.onLowMemory();
    }

    
}
