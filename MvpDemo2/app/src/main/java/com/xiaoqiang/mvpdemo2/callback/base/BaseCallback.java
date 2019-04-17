package com.xiaoqiang.mvpdemo2.callback.base;

public interface BaseCallback<T> {

    void onSuccess(T data);

    void onFailed(T data, String msg);

    void onError(String msg);

    void onFinish();
}
