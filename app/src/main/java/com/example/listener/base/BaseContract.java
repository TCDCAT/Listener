package com.example.listener.base;

import io.reactivex.disposables.Disposable;

public interface BaseContract {
    interface BasePresenter<T extends BaseView>{

        /**
         * 添加View
         * @param view BaseView子接口的实现
         */
        void attachView(T view);

        /**
         * 解除View
         */
        void detachView();

        /**
         * 往CompositeDisposable中添加disposable
         * @param disposable
         */
        void addDisposable(Disposable disposable);

        /**
         * 清除disposable
         */
        void clearDisposable();
    }
    interface BaseView{}
    interface BaseModel{}
}
