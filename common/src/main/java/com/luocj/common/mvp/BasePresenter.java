package com.luocj.common.mvp;

import android.app.Activity;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.internal.Preconditions;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<M extends IModel, V extends IView> implements IPresenter<V> {
    private M mModel;
    private V mView;
    private CompositeDisposable compositeDisposable;

    public BasePresenter() {
        this.mModel = createrModel();
    }

    protected abstract M createrModel();

    public V getView() {
        Preconditions.checkNotNull(mView, "%s cannot be null");
        return mView;
    }

    public M getModel() {
        Preconditions.checkNotNull(mModel, "%s cannot be null");
        return mModel;
    }

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    /**
     * 解除绑定
     */
    @Override
    public void detachView() {
        unDispose();
        mView = null;
    }

    /**
     * 将 {@link Disposable} 添加到 {@link CompositeDisposable} 中统一管理
     * 可在 {@link Activity#onDestroy()} 中使用 {@link #unDispose()} 停止正在执行的 RxJava 任务，避免内存泄漏(框架已自行处理)
     *
     * @param disposable
     */
    public void addDispose(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);// 将所有 Disposable 放入集中处理
    }

    /**
     * 停止集合中正在执行的 RxJava 任务
     */
    public void unDispose() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();// 保证 Activity 结束时取消所有正在执行的订阅
        }
    }

    protected <T> LifecycleProvider<T> getLifecycleProvider() {
        LifecycleProvider<T> provider = null;
        if (null != mView && mView instanceof LifecycleProvider) {
            provider = (LifecycleProvider<T>) mView;
        }
        return provider;
    }

}
