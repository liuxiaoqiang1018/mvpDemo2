package com.xiaoqiang.mvpdemo2.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.xiaoqiang.mvpdemo2.presenter.base.BasePresenter;
import com.xiaoqiang.mvpdemo2.view.base.BaseView;


public abstract class BaseActivity<P extends BasePresenter> extends Activity implements BaseView {

    protected P mPresenter;

    protected ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("正在加载......");
        mPresenter = getPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
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

    protected abstract int getContentView();

    protected abstract P getPresenter();
}
