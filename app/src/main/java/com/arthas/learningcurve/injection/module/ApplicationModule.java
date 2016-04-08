package com.arthas.learningcurve.injection.module;

import android.content.Context;

import com.dili.clean.executor.PostExecutionThread;
import com.dili.clean.executor.ThreadExecutor;
import com.dili.clean.executor.impl.PostExecutionThreadImpl;
import com.dili.clean.executor.impl.ThreadExecutorImpl;
import com.dili.clean.ui.AbstractBaseApplication;
import com.f2prateek.rx.preferences.RxSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by garrett on 3/10/16.
 */
@Module
public final class ApplicationModule {

    private final AbstractBaseApplication application;

    public ApplicationModule(AbstractBaseApplication application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.application.getApplicationContext();
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(ThreadExecutorImpl threadExecutor) {
        return threadExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(PostExecutionThreadImpl postExecutionThread) {
        return postExecutionThread;
    }

    @Provides @Singleton
    RxSharedPreferences provideRxSharedPreferences() {
        return RxSharedPreferences.create(this.application.getSharedPreferences("user_pref", Context.MODE_PRIVATE));
    }
}
