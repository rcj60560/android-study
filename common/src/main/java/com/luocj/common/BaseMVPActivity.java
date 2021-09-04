package com.luocj.common;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.luocj.common.mvp.BasePresenter;
import com.luocj.common.mvp.IView;

public abstract class BaseMVPActivity<T extends BasePresenter> extends BaseActivity implements IView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    protected abstract T createPresenter();

    @Override
    public void showLoading() {
        showLoadingDialog();
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}

