package com.xiaoqiang.mvpdemo2.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.xiaoqiang.mvpdemo2.ui.presenter.base.BasePresenter;
import com.xiaoqiang.mvpdemo2.ui.view.base.BaseView;


/**
 * @author lxq
 * @date 2019年4月19日 21:58:00
 * 基础Activity
 */
public abstract class BaseActivity<P extends BasePresenter> extends Activity implements BaseView {

    /**
     * 使用泛型约束Presenter类型
     */
    protected P mPresenter;

    protected ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("正在加载......");

        //判断是否使用MVP模式
        if ((mPresenter = getPresenter()) != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    @Override
    public void showLoading() {
        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showFailed(String msg) {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    /**
     * 获取layout
     * 由子类实现
     *
     * @return
     */
    protected abstract int getContentView();

    /**
     * 获取Presenter
     * 由子类实现
     * 如果不使用MVP模式，返回null即可
     *
     * @return
     */
    protected abstract P getPresenter();
}
