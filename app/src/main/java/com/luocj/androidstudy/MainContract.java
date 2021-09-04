package com.luocj.androidstudy;

import com.luocj.common.mvp.BaseHttpResult;
import com.luocj.common.mvp.IModel;
import com.luocj.common.mvp.IView;

import java.util.List;

import io.reactivex.Observable;

public interface MainContract {
    interface View extends IView {
        void showData();
    }

    interface Model extends IModel {
        Observable<BaseHttpResult<List<TestNews>>> getGankData();
    }
}
