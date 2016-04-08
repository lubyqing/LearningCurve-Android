package com.arthas.learningcurve.injection.module;

import com.dili.clean.interactor.GetContactNumber;
import com.dili.clean.interactor.UserLogout;
import com.dili.clean.interactor.VersionCheck;
import com.dili.clean.interactor.impl.GetContactNumberImpl;
import com.dili.clean.interactor.impl.UserLogoutImpl;
import com.dili.clean.interactor.impl.VersionCheckImpl;
import com.dili.clean.repository.VersionRepository;
import com.dili.clean.repository.impl.VersionRepositoryImpl;
import com.dili.presentation.SettingPresenter;
import com.dili.presentation.impl.SettingPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public final class VersionUpgradeModule {
    @Provides
    VersionCheck provideVersionCheck(VersionCheckImpl versionCheck) {
        return versionCheck;
    }

    @Provides
    SettingPresenter provideSettingPresenter(SettingPresenterImpl settingPresenter) {
        return settingPresenter;
    }

    @Provides
    VersionRepository provideVersionRepository(VersionRepositoryImpl versionRepository) {
        return versionRepository;
    }

    @Provides
    GetContactNumber provideGetContactNumber(GetContactNumberImpl getContactNumber){
        return getContactNumber;
    }

    @Provides
    UserLogout provideUserLogout(UserLogoutImpl userLogout){
        return userLogout;
    }


}
