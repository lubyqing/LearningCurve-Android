package com.arthas.learningcurve.injection.component;

import com.dili.injection.PerActivity;
import com.dili.injection.component.module.TokenModule;
import com.dili.injection.component.module.VersionUpgradeModule;
import com.dili.mobsite.SettingActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {VersionUpgradeModule.class, TokenModule.class})
public interface SettingComponent {
    void inject(SettingActivity activity);
}
