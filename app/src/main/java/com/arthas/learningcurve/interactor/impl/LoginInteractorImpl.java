package com.arthas.learningcurve.interactor.impl;

import com.arthas.learningcurve.domain.BaseUserInfo;
import com.arthas.learningcurve.domain.LoginReq;
import com.arthas.learningcurve.executor.PostExecutionThread;
import com.arthas.learningcurve.executor.ThreadExecutor;
import com.arthas.learningcurve.interactor.BaseInteractor;
import com.arthas.learningcurve.model.Token;
import com.arthas.learningcurve.model.UserInfo;
import com.arthas.learningcurve.model.UserInfoModel;
import com.arthas.learningcurve.repository.UserManageRepository;

import rx.Observable;

import javax.inject.Inject;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public class LoginInteractorImpl  extends BaseInteractor {
    private UserManageRepository userManageRepository;
    private String mobile;
    private String verifyCode;

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Inject
    public LoginInteractorImpl(UserManageRepository userManageRepository, ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread) {
        super(threadExecutor,postExecutionThread);
        this.userManageRepository = userManageRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        LoginReq req = new LoginReq();
        req.setMobile(mobile);
        req.setSmsCode(verifyCode);
        return userManageRepository.login(req).map(resp -> {
            UserInfoModel userInfoModel = new UserInfoModel();
            userInfoModel.setCode(resp.getCode());
            userInfoModel.setMessage(resp.getMessage());

            com.arthas.learningcurve.domain.Token  serverToken = resp.getToken();
            if(serverToken != null) {
                Token token = new Token(serverToken.getUserId(), serverToken.getLoginTime());
                userInfoModel.setToken(token);
            }

            BaseUserInfo baseUserInfo = resp.getUserInfo();

            UserInfo localUserInfo = new UserInfo();
            localUserInfo.setMobile(baseUserInfo.getMobile());
            localUserInfo.setCardNumber(baseUserInfo.getCardNumber());
            localUserInfo.setGender(baseUserInfo.getGender());
            localUserInfo.setNickName(baseUserInfo.getNickName());
            localUserInfo.setRealName(baseUserInfo.getRealName());
            localUserInfo.setSignature(baseUserInfo.getSignature());
            localUserInfo.setUserIcon(baseUserInfo.getUserIcon());

            userInfoModel.setUserInfo(localUserInfo);
            return userInfoModel;
        });
    }
}
