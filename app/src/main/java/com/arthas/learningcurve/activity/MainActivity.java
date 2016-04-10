package com.arthas.learningcurve.activity;

import android.os.Bundle;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arthas.learningcurve.R;

public class MainActivity extends BaseActivity {

    @Bind(R.id.btn_toLogin)
    Button mToLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_toLogin)
    void onClick(){
        startActivity(LoginActivity.class);
    }
}
