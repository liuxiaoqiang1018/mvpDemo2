package com.xiaoqiang.mvpdemo2.model.base;


import com.xiaoqiang.mvpdemo2.callback.base.BaseCallback;

public abstract class BaseModel<T extends BaseCallback> {
    protected String[] params;

    public BaseModel param(String... param) {
        params = param;
        return this;
    }

    public abstract void execute(T callback);

    protected void get(T callback) {

    }

    protected void post(T callback) {

    }

}
