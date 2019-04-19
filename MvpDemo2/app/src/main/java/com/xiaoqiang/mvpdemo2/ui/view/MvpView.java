package com.xiaoqiang.mvpdemo2.ui.view;

import com.xiaoqiang.mvpdemo2.ui.view.base.BaseView;

/**
 * @author lxq
 * @date 2019年4月19日 21:56:45
 * <p>
 * 示例View
 */
public interface MvpView extends BaseView {

    /**
     * 示例
     * 显示数据 由Activity实现 Presenter调用
     *
     * @param data
     */
    void showData(String data);
}
