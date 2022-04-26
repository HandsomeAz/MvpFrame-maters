package com.geo.mvpframe_maters.activity;

import com.geo.mvpframe_maters.mvp.BaseMvpPresenter;

public class TestPresenter extends BaseMvpPresenter<TestContract.IView,TestModel> implements TestContract.IPresenter{

    @Override
    public void getTestData() {
        getModel().getUpdateInfo(userNetWork);
//        getView().setTestData("6666");
    }
}
