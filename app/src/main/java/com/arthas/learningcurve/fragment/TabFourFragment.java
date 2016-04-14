package com.arthas.learningcurve.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.arthas.learningcurve.R;
import com.arthas.learningcurve.activity.LoginActivity;
import com.arthas.learningcurve.activity.UserInfoActivity;
import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.model.UserInfo;
import com.arthas.learningcurve.utils.AppPrefsUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tcz on 16/4/12.
 */
public class TabFourFragment extends BaseFragment {
    @Bind(R.id.btn_login)
    Button mLoginBtn;
    @Bind(R.id.view_not_login)
    RelativeLayout mNotLoginView;
    @Bind(R.id.iv_user_icon)
    ImageView mUserIconIv;
    @Bind(R.id.tv_user_name)
    TextView mUserNameTv;
    @Bind(R.id.view_logined)
    RelativeLayout mLoginedView;
    @Bind(R.id.tv_user_sign)
    TextView mUserSignTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.tab_four_layout, null);

        ButterKnife.bind(this, rootView);

        upateLoginState();

        return rootView;
    }

    public void upateLoginState() {
        String userId = AppPrefsUtils.getString(Constant.SpUserConstant.KEY_USER_ID,null);
        mNotLoginView.setVisibility(userId == null ? View.VISIBLE : View.GONE);
        mLoginedView.setVisibility(userId == null ? View.GONE : View.VISIBLE);

        String userInfoStr = AppPrefsUtils.getString(Constant.SpUserConstant.KEY_USER_INFO,null);
        if (userInfoStr != null){
            UserInfo userInfo = JSON.parseObject(userInfoStr,UserInfo.class);
            mUserNameTv.setText(userInfo.getNickName() == null ? "未设置昵称" : userInfo.getNickName());
            mUserSignTv.setText(userInfo.getSignature() == null ? "未设置签名" : userInfo.getSignature() );
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btn_login, R.id.view_logined})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_login:
                intent.setClass(getActivity(), LoginActivity.class);
                intent.putExtra(Constant.KEY_CLASS_NAME, getActivity().getClass().getName());
                break;
            case R.id.view_logined:
                intent.setClass(getActivity(), UserInfoActivity.class);
                break;
        }
        startActivity(intent);
    }

}
