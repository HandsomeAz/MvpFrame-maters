package com.geo.mvpframe_maters.activity;

import android.util.Log;

import com.geo.mvpframe_maters.mvp.BaseMvpModel;
import com.geo.mvpframe_maters.network.BaseObserver;
import com.geo.mvpframe_maters.network.RequestBean;
import com.geo.mvpframe_maters.network.UserNetWork;

import io.reactivex.disposables.Disposable;

public class TestModel extends BaseMvpModel implements TestContract.IModel {



    @Override
    public void getUpdateInfo(UserNetWork userNetWork) {
        userNetWork.toGetUpdateInfo(new BaseObserver<RequestBean<String>>() {
            @Override
            public void onDisposable(Disposable d) {

            }

            @Override
            public void onSuccess(RequestBean<String> stringRequestBean) {
                Log.d("升级访问成功",stringRequestBean.toString());
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }
}
