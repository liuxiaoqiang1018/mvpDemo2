package com.xiaoqiang.mvpdemo2.model.base;

import com.xiaoqiang.mvpdemo2.callback.base.BaseCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础model
 * 规范mvp--Model层请求和响应数据
 * <p>
 * 使用泛型约束回调类型，所有的回调类型必须继承自BaseCallback
 *
 * @author lxq
 * @注意 ： 当泛型出现在方法返回值的前面即表示：当前泛型与类的泛型无关
 * @2019年4月17日 22:38:56
 */
public abstract class BaseModel<T extends BaseCallback> {

    /**
     * 请求参数
     */
    protected Map<String, String> paramMap = new HashMap<>();

    /**
     * 接受键值对参数
     * <p>
     * 使用泛型约束返回值类型，因面向对象特性，此处可进行“强制类型转换”或叫“向下造型”
     * 这样就可以访问子类的开放方法和开放属性
     *  TODO 此处可能会翻车 抛出ClassCastException,也就是类型转换异常
     * @param key
     * @param value
     * @return
     */
    public <E extends BaseModel> E param(String key, String value) {
        paramMap.put(key, value);
        return (E) this;
    }

    /**
     * 接受map参数
     *
     * @param map
     * @return
     */
    public <E extends BaseModel> E param(Map<String, String> map) {
        paramMap.putAll(map);
        return (E) this;
    }

    /**
     * 执行具体操作的抽象方法
     *
     * @param callback 返回结果回调
     */
    public abstract void execute(T callback);

    /**
     * 执行 get请求
     *
     * @param callback
     */
    protected void get(T callback) {

    }

    /**
     * 执行 post请求
     *
     * @param callback
     */
    protected void post(T callback) {

    }

}
