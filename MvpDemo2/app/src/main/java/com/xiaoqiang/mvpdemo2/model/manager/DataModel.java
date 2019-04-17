package com.xiaoqiang.mvpdemo2.model.manager;

import com.xiaoqiang.mvpdemo2.model.base.BaseModel;

public class DataModel {

    public static BaseModel getModel(Class clazz) {
        BaseModel model = null;
            try {
                model = (BaseModel) clazz.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }


        return model;
    }
}
