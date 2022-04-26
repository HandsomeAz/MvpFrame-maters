package com.geo.mvpframe_maters.mvp.base.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.geo.mvpframe_maters.mvp.IBaseView;
import com.geo.mvpframe_maters.mvp.inject.ViewInject;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    /**
     * 加载弹框
     */
    private Dialog loadingDialog;


    public abstract void afterBindView();

    public abstract void processData();


    //view的依赖绑定注入
    private void bindView() {
        ButterKnife.bind(this);
    }
    /**
     * 初始化监听器
     */
    protected void addListeners() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null){
            int mainLayoutId = annotation.mainLayoutId();
            if (mainLayoutId > 0){
                setContentView(mainLayoutId);

            }else {
                throw new RuntimeException("mainLayoutId 加载<0");
            }
        }else {
            throw new RuntimeException("mainLayoutId is null");
        }
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        bindView();
        afterBindView();
        addListeners();
        processData();
    }


    /**
     * 吐司
     */
    @Override
    public void showToast(String message) {
//        ToastUtil.getInstance().showToast(message, R.layout.toast_message);
    }

    @Override
    public void showLoading(String message) {
        hideLoading();
//        loadingDialog = new WaitDialog(this).setCancelable(false).setText(message).builder();
//        loadingDialog.show();
    }

    @Override
    public void showLoading() {
        hideLoading();
//        loadingDialog = new WaitDialog(this).setCancelable(false).setText(getString(R.string.loading)).builder();
//        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
//        if (null != loadingDialog && loadingDialog.isShowing()) {
//            loadingDialog.dismiss();
//        }
    }

    /**
     * 控制物理返回键是否可用
     */
    protected boolean backKeyEnable() {
        return false;
    }

//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//        //处理返回按键 统一关闭Activity的方法
//        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
//            if (backKeyEnable()) {
//                backEvent();
//            }
//            return true;
//        }
//        return super.dispatchKeyEvent(event);
//    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        AppManager.getInstance().removeActivity(this);
    }
}

