package com.xiaoqiang.mvpdemo2.view.base;

import android.content.Context;

public interface BaseView {

    void showLoading();

    void hideLoading();

    void showFailed(String msg);

    void showError(String msg);

    Context getContext();
}
