package com.arthas.learningcurve.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.widget.SingleLineText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tcz on 16/4/14.
 */
public class UserInfoActivity extends BaseActivity {
    @Bind(R.id.btn_logout)
    Button mLogoutBtn;
    @Bind(R.id.view_icon)
    SingleLineText mIconView;
    @Bind(R.id.view_name)
    SingleLineText mNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_logout)
    public void onClick() {

    }

    @OnClick({R.id.view_icon, R.id.view_name})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_icon:
                startActivity(EditUserActivity.class);
                break;
            case R.id.view_name:
                break;
        }
    }
}
