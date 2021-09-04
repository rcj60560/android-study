package com.luocj.androidstudy;

import android.util.Log;

import com.luocj.common.mvp.BaseHttpResult;
import com.luocj.common.mvp.BaseModel;

import java.util.List;

import io.reactivex.Observable;

public class MainModel extends BaseModel implements MainContract.Model {

    @Override
    public Observable<BaseHttpResult<List<TestNews>>> getGankData() {
        Log.i("TAG", "getGankData: ");
        return null;
    }
}
