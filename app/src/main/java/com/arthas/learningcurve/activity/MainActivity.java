package com.arthas.learningcurve.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.fragment.TabOneFragment;
import com.arthas.learningcurve.fragment.TabTwoFragment;
import com.arthas.learningcurve.fragment.TabThreeFragment;
import com.arthas.learningcurve.fragment.TabFourFragment;
import com.arthas.learningcurve.fragment.TabCenterFragment;
import com.arthas.learningcurve.widget.BottomNavigator;

import java.util.Stack;

public class MainActivity extends BaseActivity implements BottomNavigator.OnItemChangedListener{
    private Stack<Fragment> mFragmentStack;

    private static final String FRAGMENT_ONE_TAG = "fragment_one_tag";
    private static final String FRAGMENT_TWO_TAG = "fragment_two_tag";
    private static final String FRAGMENT_THREE_TAG = "fragment_three_tag";
    private static final String FRAGMENT_FOUR_TAG = "fragment_four_tag";
    private static final String FRAGMENT_CENTER_TAG = "fragment_center_tag";


    private TabOneFragment mTabOneFragment;
    private TabTwoFragment mTabTwoFragment;
    private TabThreeFragment mTabThreeFragment;
    private TabFourFragment mTabFourFragment;
    private TabCenterFragment mTabCenterFragment;

    @Bind(R.id.view_bottom_tab)
    BottomNavigator mBottomNavigator;

    private int mCurrentIndex;

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

            mTabOneFragment = new TabOneFragment();
            mFragmentTransaction.add(R.id.view_container, mTabOneFragment, FRAGMENT_ONE_TAG);

            mTabTwoFragment = new TabTwoFragment();
            mFragmentTransaction.add(R.id.view_container, mTabTwoFragment, FRAGMENT_TWO_TAG);

            mTabThreeFragment = new TabThreeFragment();
            mFragmentTransaction.add(R.id.view_container, mTabThreeFragment, FRAGMENT_THREE_TAG);

            mTabFourFragment = new TabFourFragment();
            mFragmentTransaction.add(R.id.view_container, mTabFourFragment, FRAGMENT_FOUR_TAG);

            mTabCenterFragment = new TabCenterFragment();
            mFragmentTransaction.add(R.id.view_container, mTabCenterFragment, FRAGMENT_CENTER_TAG);


            mFragmentTransaction.commit();

        } else {
            FragmentManager fManager = getSupportFragmentManager();
            mTabOneFragment = (TabOneFragment) fManager.findFragmentByTag(FRAGMENT_ONE_TAG);
            mTabTwoFragment = (TabTwoFragment) fManager.findFragmentByTag(FRAGMENT_TWO_TAG);
            mTabThreeFragment = (TabThreeFragment) fManager.findFragmentByTag(FRAGMENT_THREE_TAG);
            mTabFourFragment = (TabFourFragment) fManager.findFragmentByTag(FRAGMENT_FOUR_TAG);
            mTabCenterFragment = (TabCenterFragment) fManager.findFragmentByTag(FRAGMENT_CENTER_TAG);
            if (null != mFragmentStack) {
                mFragmentStack.clear();
                mFragmentStack = null;
            }
        }
        mFragmentStack.add(mTabOneFragment);
        mFragmentStack.add(mTabTwoFragment);
        mFragmentStack.add(mTabThreeFragment);
        mFragmentStack.add(mTabFourFragment);
        mFragmentStack.add(mTabCenterFragment);
    }

    @Override
    public void onItemChanged(int index) {
        updateFragment(index);
    }

    private void updateFragment(int index){
        mCurrentIndex = index;
        updateBottomNavigator(index);

        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();

        for(Fragment fragment : mFragmentStack){
            mFragmentTransaction.hide(fragment);
        }

        Fragment fragment = mFragmentStack.get(index);

        mFragmentTransaction.show(fragment);
        mFragmentTransaction.commitAllowingStateLoss();
    }

    private void updateBottomNavigator(int index){
        mBottomNavigator.updateSelectState(index);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        switch (mCurrentIndex){
            case 3:
                mTabFourFragment.upateLoginState();
                break;
        }
    }
}
