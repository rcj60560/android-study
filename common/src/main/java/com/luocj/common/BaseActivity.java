package com.luocj.common;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public abstract class BaseActivity extends RxAppCompatActivity {
    private ProgressDialog loadingDialog = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        Intent intent = getIntent();
        if (intent != null) {
            getIntent(intent);
        }
        initView();
        initData();
        initListener();
    }

    protected  void initListener(){

    };

    protected abstract void initData();

    protected abstract void initView();

    private Intent getIntent(Intent intent) {
        return intent;
    }

    protected abstract int getLayoutId();

    /**
     * 显示带消息的进度框
     *
     * @param title 提示
     */
    protected void showLoadingDialog(String title) {
        createLoadingDialog();
        loadingDialog.setMessage(title);
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    /**
     * 显示进度框
     */
    protected void showLoadingDialog() {
        createLoadingDialog();
        if (!loadingDialog.isShowing())
            loadingDialog.show();
    }

    /**
     * 创建LoadingDialog
     */
    private void createLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new ProgressDialog(this);
            loadingDialog.setCancelable(true);
            loadingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /**
     * 隐藏进度框
     */
    protected void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
}
