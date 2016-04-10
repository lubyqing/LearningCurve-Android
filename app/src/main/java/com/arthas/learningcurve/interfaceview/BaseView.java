package com.arthas.learningcurve.interfaceview;

/**
 * Created by Arthas_T on 2016/4/10.
 */
public interface BaseView {
    void showLoading();
    void dismissLoading();
    void showErrorMsg(int errorId);
    void showErrorMsg(String errorMsg);
}
