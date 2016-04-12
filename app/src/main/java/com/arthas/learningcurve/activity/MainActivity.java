package com.arthas.learningcurve.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.fragment.Tab1Fragment;
import com.arthas.learningcurve.fragment.Tab2Fragment;
import com.arthas.learningcurve.fragment.Tab3Fragment;
import com.arthas.learningcurve.fragment.Tab4Fragment;
import com.arthas.learningcurve.fragment.TabCenterFragment;
import com.arthas.learningcurve.widget.BottomNavigator;

import java.util.Stack;

public class MainActivity extends BaseActivity implements BottomNavigator.OnItemChangedListener{
    private Stack<Fragment> mFragmentStack;

    private static final String TAB1_TAG = "tab1_tag";
    private static final String TAB2_TAG = "tab2_tag";
    private static final String TAB3_TAG = "tab3_tag";
    private static final String TAB4_TAG = "tab4_tag";
    private static final String TAB_CENTER_TAG = "tab_center_tag";


    private Tab1Fragment mTab1Fragment;
    private Tab2Fragment mTab2Fragment;
    private Tab3Fragment mTab3Fragment;
    private Tab4Fragment mTab4Fragment;
    private TabCenterFragment mTabCenterFragment;

    @Bind(R.id.view_bottom_tab)
    BottomNavigator mBottomNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initFragments(savedInstanceState);
        mBottomNavigator.setOnItemChangedListener(this);

        updateFragment(0);
    }


    /**
     * 初始所有fragment 预加载
     */
    private void initFragments(Bundle savedInstanceState) {
        if (null == savedInstanceState) {
            FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();

            mFragmentStack = new Stack<Fragment>();

            mTab1Fragment = new Tab1Fragment();
            mFragmentTransaction.add(R.id.view_container, mTab1Fragment, TAB1_TAG);

            mTab2Fragment = new Tab2Fragment();
            mFragmentTransaction.add(R.id.view_container, mTab2Fragment, TAB2_TAG);

            mTab3Fragment = new Tab3Fragment();
            mFragmentTransaction.add(R.id.view_container, mTab3Fragment, TAB3_TAG);

            mTab4Fragment = new Tab4Fragment();
            mFragmentTransaction.add(R.id.view_container, mTab4Fragment, TAB4_TAG);

            mTabCenterFragment = new TabCenterFragment();
            mFragmentTransaction.add(R.id.view_container, mTabCenterFragment, TAB_CENTER_TAG);


            mFragmentTransaction.commit();

        } else {
            FragmentManager fManager = getSupportFragmentManager();
            mTab1Fragment = (Tab1Fragment) fManager.findFragmentByTag(TAB1_TAG);
            mTab2Fragment = (Tab2Fragment) fManager.findFragmentByTag(TAB2_TAG);
            mTab3Fragment = (Tab3Fragment) fManager.findFragmentByTag(TAB3_TAG);
            mTab4Fragment = (Tab4Fragment) fManager.findFragmentByTag(TAB4_TAG);
            mTabCenterFragment = (TabCenterFragment) fManager.findFragmentByTag(TAB_CENTER_TAG);
            if (null != mFragmentStack) {
                mFragmentStack.clear();
                mFragmentStack = null;
            }
        }
        mFragmentStack.add(mTab1Fragment);
        mFragmentStack.add(mTab2Fragment);
        mFragmentStack.add(mTab3Fragment);
        mFragmentStack.add(mTab4Fragment);
        mFragmentStack.add(mTabCenterFragment);
    }

    @Override
    public void onItemChanged(int index) {
        updateFragment(index);
    }

    private void updateFragment(int index){
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();

        for(Fragment fragment : mFragmentStack){
            mFragmentTransaction.hide(fragment);
        }

        Fragment fragment = mFragmentStack.get(index);

        mFragmentTransaction.show(fragment);
        mFragmentTransaction.commitAllowingStateLoss();

    }
}
