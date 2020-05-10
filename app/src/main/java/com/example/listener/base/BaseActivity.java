package com.example.listener.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.example.listener.util.ActivityCollector;

public abstract class BaseActivity<B extends ViewBinding, V extends BaseContract.BaseView, P extends BaseContract.BasePresenter<V>> extends AppCompatActivity {
    protected P mPresenter;
    protected B mViewBinding;

    protected abstract B initViewBinding();

    protected abstract void initView(B viewBinding);

    protected abstract void initData();

    protected abstract P initPresenter();

    protected abstract void attachView();

    protected abstract void detachView();

    protected final String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = initViewBinding();
        setContentView(mViewBinding.getRoot());
        initView(mViewBinding);
        initData();
        mPresenter = initPresenter();
        attachView();
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detachView();
        ActivityCollector.removeActivity(this);
    }
}
