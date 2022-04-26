package com.geo.mvpframe_maters.mvp.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.geo.mvpframe_maters.mvp.proxy.ProxyFragment;

public abstract class BaseMvpFragment extends BaseFragment {

    private ProxyFragment mProxyFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mProxyFragment = createProxyFragment();
        mProxyFragment.bindPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    private ProxyFragment createProxyFragment() {
        if (mProxyFragment == null) {
            return new ProxyFragment(this);
        }
        return mProxyFragment;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mProxyFragment.unbindPresenter();
    }
}
