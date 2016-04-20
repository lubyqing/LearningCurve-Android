package com.arthas.learningcurve.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.adapter.IconFontAdapter;
import com.arthas.learningcurve.common.Constant;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tcz on 16/4/20.
 */
public class IconFontActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    @Bind(R.id.gv_category_icon)
    GridView mCategoryIconGridView;
    
    private IconFontAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_icon);
        ButterKnife.bind(this);

        initData();
    }
    
    private void initData(){
        mCategoryIconGridView.setOnItemClickListener(this);

        mAdapter = new IconFontAdapter(this);
        mCategoryIconGridView.setAdapter(mAdapter);
        mAdapter.setList(getResources().getStringArray(R.array.icon_font));
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.push_buttom_out);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = (String) parent.getItemAtPosition(position);
        Intent intent = getBackOnNewIntent();
        intent.putExtra(Constant.KEY_ICON_FONT,text);
        startActivity(intent);
        finish();
    }
}
