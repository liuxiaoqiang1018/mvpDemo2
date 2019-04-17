package com.xiaoqiang.mvpdemo2.model;

import android.os.Handler;
import android.text.TextUtils;

import com.xiaoqiang.mvpdemo2.callback.MvpCallback;
import com.xiaoqiang.mvpdemo2.model.base.BaseModel;


/**
 * @author lxq
 * @2019年4月17日 22:40:44
 * mvp 演示model
 */
public class MvpModel extends BaseModel<MvpCallback<String>> {

    @Override
    public void execute(MvpCallback callback) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!TextUtils.isEmpty(paramMap.get("data"))) {
                    switch (paramMap.get("data")) {
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
