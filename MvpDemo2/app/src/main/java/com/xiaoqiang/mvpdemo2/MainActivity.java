package com.xiaoqiang.mvpdemo2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.xiaoqiang.mvpdemo2.presenter.MvpPresenter;
import com.xiaoqiang.mvpdemo2.ui.BaseActivity;
import com.xiaoqiang.mvpdemo2.view.MvpView;


public class MainActivity extends BaseActivity<MvpPresenter> implements MvpView {

    TextView msg;
    Button success;
    Button failed;
    Button error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        msg = findViewById(R.id.msg);
        success = findViewById(R.id.success);
        failed = findViewById(R.id.failed);
        error = findViewById(R.id.error);

        success.setOnClickListener(v -> {
            mPresenter.getNetworkData("success");
        });
        failed.setOnClickListener(v -> {
            mPresenter.getNetworkData("failed");
        });
        error.setOnClickListener(v -> {
            mPresenter.getNetworkData("error");
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
}
