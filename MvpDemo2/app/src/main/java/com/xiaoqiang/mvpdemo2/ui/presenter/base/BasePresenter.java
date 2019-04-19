package com.xiaoqiang.mvpdemo2.ui.presenter.base;


import com.xiaoqiang.mvpdemo2.ui.view.base.BaseView;

/**
 * @author lxq
 * @date 2019年4月19日 21:49:17
 * 基础Presenter
 *
 * Presenter希望所有的View都继承自BaseView,所以用泛型约束
 */
public class BasePresenter<V extends BaseView> {

    private V mView;

    /**
     * 绑定View
     * @param view
     */
    public void attachView(V view){
        mView = view;
    }

    /**
     * 解绑View
     */
    public void detachView(){
        mView = null;
    }

    /**
     * 判断view是否存活
     * @return
     */
    public boolean isAttachedView(){
        return mView != null;
    }

    /**
     * 返回view
     * @return
     */
    public V getView(){
        return mView;
    }
}
