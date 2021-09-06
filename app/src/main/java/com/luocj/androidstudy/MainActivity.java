package com.luocj.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.luocj.common.BaseMVPActivity;
import com.luocj.common.utils.ToastUtils;

public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        mPresenter.showToast();
    }

    @Override
    protected void initView() {
        Log.i(TAG, "initView: ");
    }

    @Override
    protected void initData() {
        Log.i(TAG, "initData: ");
    }

    @Override
    protected void initListener() {
        Log.i(TAG, "initListener: ");
    }

    @Override
    protected int getLayoutId() {
        Log.i(TAG, "getLayoutId: ");
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter createPresenter() {
        Log.i(TAG, "createPresenter: ");
        return new MainPresenter();
    }


    public void shark(View view) {
        Log.i(TAG, "shark: ");
        startActivity(new Intent(this, MainSharkActivity.class));
    }

    @Override
    public void showToast() {
        Log.i(TAG, "showToast: ");
        ToastUtils.showLongToast("toast");
    }
}