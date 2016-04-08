package com.arthas.learningcurve.injection.component;

import android.content.Context;

import com.dili.clean.executor.PostExecutionThread;
import com.dili.clean.executor.ThreadExecutor;
import com.dili.clean.ui.AbstractBaseActivity;
import com.dili.injection.component.module.ApplicationModule;
import com.f2prateek.rx.preferences.RxSharedPreferences;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by garrett on 3/10/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(AbstractBaseActivity baseActivity);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    RxSharedPreferences rxSharedPreferences();
}
