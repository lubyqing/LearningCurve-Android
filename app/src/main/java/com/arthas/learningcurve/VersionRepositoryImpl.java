package com.arthas.learningcurve;

import android.util.Log;

import com.dili.clean.model.VersionCheckModel;
import com.dili.clean.repository.BaseMobsiteRepository;
import com.dili.clean.repository.VersionRepository;
import com.dili.mobsite.net.service.UserService;
import com.dili.mobsite.net.service.VersionService;
import com.diligrp.mobsite.getway.domain.protocol.common.GetSystemConfigReq;
import com.diligrp.mobsite.getway.domain.protocol.login.LogoutReq;
import com.diligrp.mobsite.getway.domain.protocol.version.CheckVersionReq;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by tanchuanzhi on 16/3/29.
 */
public class VersionRepositoryImpl extends BaseMobsiteRepository implements VersionRepository {
    @Inject
    public VersionRepositoryImpl() {
    }


    @Override
    public Observable<VersionCheckModel> checkVersion() {

        CheckVersionReq req = new CheckVersionReq();
        return  RetrofitBuilderFactory.create().build().create(VersionService.class).checkVersion(req).map(resp -> {
            if(resp == null
                    || resp.getCode() != 200){
                Log.e("Versioncheck error", resp.getMsg());

                return null;

            }
            VersionCheckModel model = new VersionCheckModel();
            model.setUpgradeLevel(resp.getForceFlag());
            model.setUpgradeInfo(resp.getDescription());
            model.setUpgradeUrl(resp.getAppUrl());
            return model;
        });

    }

    @Override
    public Observable<String> getContactNumber() {
        GetSystemConfigReq req = new GetSystemConfigReq();
        req.setCode("Client_Service_Hot_Line");
        return  RetrofitBuilderFactory.create().build().create(CommonService.class).getSystemConfig(req).map(resp -> {
            if(resp == null
                    || resp.getCode() != 200){
                Log.e("Setting getContactNumber", resp.getMsg());

                return null;

            }
            return resp.getContent();
        });
    }

    @Override
    public Observable<Integer> logout(String pushId) {
        LogoutReq req = new LogoutReq();
        req.setToken(getToken());
        req.setRegisterNo(pushId);
        return  RetrofitBuilderFactory.create().build().create(UserService.class).logout(req).map(resp -> resp.getCode());
    }
}
