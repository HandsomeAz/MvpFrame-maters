package com.geo.mvpframe_maters.activity;

import com.geo.mvpframe_maters.mvp.BaseMvpModel;
import com.geo.mvpframe_maters.mvp.IBaseView;
import com.geo.mvpframe_maters.network.UserNetWork;

public interface TestContract {
    interface IModel {



        void getUpdateInfo(UserNetWork userNetWork);
    }

    interface IView extends IBaseView{

        void setTestData(String s);
    }

    interface IPresenter {

        void getTestData();
    }


}
