package com.luocj.androidstudy;

import com.luocj.common.mvp.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {

    @Override
    protected MainContract.Model createrModel() {
        return new MainModel();
    }
}
