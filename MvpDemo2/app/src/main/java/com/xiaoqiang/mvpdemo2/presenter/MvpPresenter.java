package com.xiaoqiang.mvpdemo2.presenter;


import com.xiaoqiang.mvpdemo2.callback.MvpCallback;
import com.xiaoqiang.mvpdemo2.model.MvpModel;
import com.xiaoqiang.mvpdemo2.model.manager.DataModel;
import com.xiaoqiang.mvpdemo2.presenter.base.BasePresenter;
import com.xiaoqiang.mvpdemo2.view.MvpView;

import java.util.HashMap;
import java.util.Map;

public class MvpPresenter extends BasePresenter<MvpView> {


    public void getNetworkData(String param) {
        if (!isAttachedView()) {
            return;
        }
        if (isAttachedView()) {
            getView().showLoading();
        }
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("data", param);
        DataModel.getModel(MvpModel.class)
                .<MvpModel>param(paramMap)
                .execute(new MvpCallback<String>() {
            @Override
            public void onSuccess(String data) {
                if (isAttachedView()) {
                    getView().showData(data);
                }
            }

            @Override
            public void onFailed(String data, String msg) {
                if (isAttachedView()) {
                    getView().showFailed(msg);
                }
            }

            @Override
            public void onError(String msg) {
                if (isAttachedView()) {
                    getView().showError(msg);
                }
            }

            @Override
            public void onFinish() {
                if (isAttachedView()) {
                    getView().hideLoading();
                }
            }
        });
    }

}
