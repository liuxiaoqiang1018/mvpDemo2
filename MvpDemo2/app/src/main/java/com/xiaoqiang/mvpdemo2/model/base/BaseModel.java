package com.xiaoqiang.mvpdemo2.model.base;

import com.xiaoqiang.mvpdemo2.callback.base.BaseCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础model
 * 规范mvp--Model层请求和响应数据
 *
 * @author lxq
 * @2019年4月17日 22:38:56
 */
public abstract class BaseModel<T extends BaseCallback> {

    /**
     * 请求参数
     */
    protected Map<String, String> paramMap = new HashMap<>();

    /**
     * 接受键值对参数
     *
     * @param key
     * @param value
     * @return
     */
    public BaseModel param(String key, String value) {
        paramMap.put(key, value);
        return this;
    }

    /**
     * 接受map参数
     *
     * @param map
     * @return
     */
    public BaseModel param(Map<String, String> map) {
        paramMap.putAll(map);
        return this;
    }

    /**
     * 执行请求数据
     * @param callback 返回结果回调
     */
    public abstract void execute(T callback);

    /**
     * 执行 get请求
     * @param callback
     */
    protected void get(T callback) {

    }

    /**
     * 执行 post请求
     * @param callback
     */
    protected void post(T callback) {

    }

}
