package com.geo.mvpframe_maters.mvp.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.geo.mvpframe_maters.mvp.proxy.ProxyActivity;

public abstract class BaseMvpActivity extends BaseActivity {


    private ProxyActivity mProxyActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProxyActivity = createProxyActivity();
        mProxyActivity.bindPresenter();
    }

    @SuppressWarnings("unchecked")
    private ProxyActivity createProxyActivity() {
        if (mProxyActivity == null) {
            return new ProxyActivity(this);
        }
        return mProxyActivity;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProxyActivity.unbindPresenter();
    }
}

