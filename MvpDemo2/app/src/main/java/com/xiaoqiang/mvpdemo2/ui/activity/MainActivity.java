package com.xiaoqiang.mvpdemo2.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.xiaoqiang.mvpdemo2.R;
import com.xiaoqiang.mvpdemo2.ui.presenter.MvpPresenter;
import com.xiaoqiang.mvpdemo2.ui.base.BaseActivity;
import com.xiaoqiang.mvpdemo2.ui.view.MvpView;


/**
 * @author lxq
 * @date 2019年4月19日 22:26:33
 * <p>
 * 示例MVP
 */
public class MainActivity extends BaseActivity<MvpPresenter> implements MvpView {

    TextView msg;
    Button success;
    Button failed;
    Button error;
    Button getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        msg = findViewById(R.id.msg);
        success = findViewById(R.id.success);
        failed = findViewById(R.id.failed);
        error = findViewById(R.id.error);
        getData = findViewById(R.id.getData);
        success.setOnClickListener(v -> {
            mPresenter.getNetworkData("success");
        });
        failed.setOnClickListener(v -> {
            mPresenter.getNetworkData("failed");
        });
        error.setOnClickListener(v -> {
            mPresenter.getNetworkData("error");
        });
        getData.setOnClickListener(view -> {
            netWork();
        });

    }

    @Override
    public void showData(String data) {
        msg.setText(data);
    }

    @Override
    public void showFailed(String msg) {
        this.msg.setText(msg);
    }

    @Override
    public void showError(String msg) {
        this.msg.setText(msg);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }


    @Override
    protected MvpPresenter getPresenter() {
        return new MvpPresenter();
    }

    /**
     * 请求网络必须在子线程里
     */
    public void netWork() {
        String url = "https://api.apishop.net/common/weather/get15DaysWeatherByArea";
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpParams httpParams = new HttpParams();
                OkGo.<String>post(url).params(httpParams).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String data = response.body();
                        Log.d("lxq", "onSuccess: " + data);
                        //显示数据到UI必须在UI线程里
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                msg.setText(data);
                            }
                        });
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        String data = response.body();
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });
            }
        }).start();

    }
}
