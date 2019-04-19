package com.xiaoqiang.mvpdemo2.ui.view.base;

import android.content.Context;

/**
 * @author lxq
 * @date 2019年4月19日 21:53:02
 * 基础View
 * <p>
 * 为View（Activity）层提供统一方法
 */
public interface BaseView {

    /**
     * 显示加载框
     */
    void showLoading();

    /**
     * 隐藏加载框
     */
    void hideLoading();

    /**
     * 显示错误信息
     *
     * @param msg
     */
    void showFailed(String msg);

    /**
     * 显示错误信息
     *
     * @param msg
     */
    void showError(String msg);

    /**
     * 获取Context
     *
     * @return
     */
    Context getContext();
}
