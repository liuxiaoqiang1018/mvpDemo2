package com.xiaoqiang.mvpdemo2.model;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.xiaoqiang.mvpdemo2.callback.MvpCallback;
import com.xiaoqiang.mvpdemo2.model.base.BaseModel;

import java.util.Arrays;


public class MvpModel extends BaseModel<MvpCallback<String>> {


    public static void getNetworkData(String param, MvpCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!TextUtils.isEmpty(param)) {
                    switch (param) {
                        case "success":
                            callback.onSuccess("请求成功");
                            break;
                        case "failed":
                            callback.onFailed("NULL", "返回失败的数据：data is null");
                            break;
                        case "error":
                            callback.onError("请求失败，请检查网络链接状态");
                            break;
                        default:
                            break;
                    }
                    callback.onFinish();
                }
            }
        }, 3000);

    }

    @Override
    public void execute(MvpCallback callback) {
        Log.d(this.getClass().getName(), Arrays.asList(params).toString());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!TextUtils.isEmpty(params[0])) {
                    switch (params[0]) {
                        case "success":
                            callback.onSuccess("请求成功");
                            break;
                        case "failed":
                            callback.onFailed("NULL", "返回失败的数据：data is null");
                            break;
                        case "error":
                            callback.onError("请求失败，请检查网络链接状态");
                            break;
                        default:
                            break;
                    }
                    callback.onFinish();
                }
            }
        }, 3000);
    }
}
