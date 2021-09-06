package com.luocj.androidstudy;

import android.util.Log;

import com.luocj.common.mvp.BaseHttpResult;
import com.luocj.common.mvp.BasePresenter;

import java.util.List;

import io.reactivex.Observable;

public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {

    @Override
    protected MainContract.Model createrModel() {
        return new MainModel();
    }


    public void requestData() {
        Observable<BaseHttpResult<List<TestNews>>> gankData = getModel().getGankData();
        Log.i("TAG", "requestData: ");
//                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
//                .subscribe(new BaseObserver<List<TestNews>>(getView()) {
//                    @Override
//                    public void onSuccess(BaseHttpResult<List<TestNews>> result) {
//                        if (result != null) {
//                            getView().showData();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(String errMsg, boolean isNetError) {
//                        getView().showError(errMsg);
//                    }
//                });
    }

    public void showToast() {
        getView().showToast();
    }
}
