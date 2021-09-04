package com.luocj.androidstudy;

import android.util.Log;
import android.view.View;

import com.luocj.common.BaseMVPActivity;

public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void showData() {
        Log.i(TAG, "showData: ");
    }

    @Override
    protected void initListener() {
        Log.i(TAG, "initListener: ");
    }

    @Override
    protected void initData() {
        Log.i(TAG, "initData: ");
    }

    @Override
    protected void initView() {
        Log.i(TAG, "initView: ");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showError(String msg) {
        Log.i(TAG, "showError: ");
    }

    public void baseAdapter(View view) {
//        startActivity(new Intent(this, TestActivity.class));
        mPresenter.requestData();

    }
}