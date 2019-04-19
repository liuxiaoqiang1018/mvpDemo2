package com.xiaoqiang.mvpdemo2.callback.base;

/**
 * @author lxq
 * @date 2019年4月19日 22:27:213
 * 基础回调
 * 帮助Presenter 和 Model 通讯
 * 约定了回调方法
 */
public interface BaseCallback<T> {

    /**
     * 请求成功
     *
     * @param data 返回的结果
     */
    void onSuccess(T data);

    /**
     * 由于系统的原因导致请求失败
     *
     * @param data
     * @param msg
     */
    void onFailed(T data, String msg);

    /**
     * 请求成功，但返回的结果是错误的
     *
     * @param msg
     */
    void onError(String msg);

    /**
     * 无论请求是否成功，都必须调用此方法做最后的处理
     */
    void onFinish();
}
