package com.xiaoqiang.mvpdemo2.model.manager;

import com.xiaoqiang.mvpdemo2.model.base.BaseModel;

/**
 * Data Model
 * mvp model层
 * 单独封装，集中管理
 * 所有数据的出入接口
 * 数据层顶级入口，项目中所有数据都由该类流入和流出，负责分发所有的请求数据。
 *
 * @author lxq
 * @2019年4月17日 22:37:45
 */
public class DataModel {

    /**
     * 利用泛型进行约束
     * 利用Class进行反射 获取想要的model
     *
     * @param clazz
     * @param <V>
     * @return
     */
    public static <V extends BaseModel> V getModel(Class<V> clazz) {
        V model = null;
        try {
            model = clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}
