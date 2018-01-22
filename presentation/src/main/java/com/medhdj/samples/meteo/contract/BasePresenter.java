package com.medhdj.samples.meteo.contract;

/**
 * Created by medhdj on 21.01.18.
 */

public interface BasePresenter<T extends BaseView> {
    void setView(T view);

    //android lifecycle related methods
    void create();

    void start();

    void stop();

    void destroy();
}
