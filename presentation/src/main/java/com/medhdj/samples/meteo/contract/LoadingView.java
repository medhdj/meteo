package com.medhdj.samples.meteo.contract;

/**
 * Created by medhdj on 21.01.18.
 */

public interface LoadingView extends BaseView {

    void showLoading();

    void hideLoading();

    void showError(String message);
}
