package com.luocj.common.mvp;

import java.io.Serializable;

public class BaseHttpResult<T> implements Serializable {
    /** test**/
    private boolean error;

    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getData() {
        return results;
    }

    public void setData(T data) {
        this.results = data;
    }

    @Override
    public String toString() {
        return "BaseHttpResult{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }

    /**
     * 正常返回
     *
     * @return
     */
    public boolean isSuccessFul() {
        return !isError();
    }
}
