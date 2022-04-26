package com.geo.mvpframe_maters.mvp.base.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geo.mvpframe_maters.mvp.IBaseView;
import com.geo.mvpframe_maters.mvp.inject.ViewInject;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements IBaseView {

    private Dialog loadingDialog;
    private View  mView = null;


    /**
     * 初始化监听器
     */
    protected void addListeners() {
    }

    private View initFragmentView(LayoutInflater inflater, int mainLayoutId) {

        return  inflater.inflate(mainLayoutId,null);
    }


    public abstract void afterBindView();

    public abstract void processData();


    //view的依赖绑定注入
    private void bindView(View view) {
        ButterKnife.bind(this,view);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null){
            int mainLayoutId = annotation.mainLayoutId();
            if (mainLayoutId > 0){
                mView = initFragmentView(inflater,mainLayoutId);
//                setContentView(mainLayoutId);
                bindView(mView);

            }else {
                throw new RuntimeException("mainLayoutId 加载<0");
            }
        }else {
            throw new RuntimeException("mainLayoutId is null");
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        afterBindView();
        addListeners();
        processData();
    }

    @Override
    public void showToast(String message) {
//        ToastUtil.getInstance().showToast(message, R.layout.toast_message);
    }

    @Override
    public void showLoading() {
        hideLoading();
//        loadingDialog = new WaitDialog(getActivity()).setCancelable(false).setText(getString(R.string.loading)).builder();
//        loadingDialog.show();
    }

    @Override
    public void showLoading(String message) {
        hideLoading();
//        loadingDialog = new WaitDialog(getActivity()).setCancelable(true).setText(message).builder();
//        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (null != loadingDialog && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }
}

