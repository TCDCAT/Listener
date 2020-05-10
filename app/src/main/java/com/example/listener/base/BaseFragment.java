package com.example.listener.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;



public abstract class BaseFragment<B extends ViewBinding, V extends BaseContract.BaseView, P extends BaseContract.BasePresenter<V>> extends Fragment {
    protected B mViewBinding;
    protected P mPresenter;
    protected Context mContext;

    protected abstract B initViewBinding(LayoutInflater inflater, ViewGroup container);

    protected abstract P initPresenter();

    protected abstract void initView();
    protected abstract void initData();

    protected abstract void attachView();

    protected abstract void detachView();
    @Override

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mPresenter = initPresenter();
        attachView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewBinding = initViewBinding(inflater, container);
        View root = mViewBinding.getRoot();
        initView();
        initData();
        return root;
    }

    /**
     * fragment比view活的更长，所以要把binding class相关引用置为null
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewBinding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        detachView();
    }
}
