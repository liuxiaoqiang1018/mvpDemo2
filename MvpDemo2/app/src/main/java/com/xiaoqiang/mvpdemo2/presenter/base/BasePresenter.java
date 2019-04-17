package com.xiaoqiang.mvpdemo2.presenter.base;


import com.xiaoqiang.mvpdemo2.view.base.BaseView;

public class BasePresenter<V extends BaseView> {

    private V mView;

    public void attachView(V view){
        mView = view;
    }

    public void detachView(){
        mView = null;
    }
    public boolean isAttachedView(){
        return mView != null;
    }

    public V getView(){
        return mView;
    }
}
