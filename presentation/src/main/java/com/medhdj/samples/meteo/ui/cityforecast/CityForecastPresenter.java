package com.medhdj.samples.meteo.ui.cityforecast;

import android.util.Log;

import com.medhdj.data.entity.CityEntity;
import com.medhdj.data.repository.ForecastDataRepository;
import com.medhdj.domain.executor.PostExecutionThread;
import com.medhdj.domain.model.Forecast;
import com.medhdj.domain.usecase.GetForcastByCoordinates;
import com.medhdj.samples.meteo.contract.BasePresenter;
import com.medhdj.samples.meteo.exception.ErrorMessageFactory;
import com.medhdj.samples.meteo.mapper.PresentationModelMapper;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by medhdj on 22/01/2018.
 */

public class CityForecastPresenter implements BasePresenter<CityForecastView> {
    private CityForecastView forecastView;

    private final GetForcastByCoordinates forcastByCoordinatesUseCase;

    public CityForecastPresenter() {
        this.forcastByCoordinatesUseCase = new GetForcastByCoordinates(new ForecastDataRepository(), new PostExecutionThread() {
            @Override
            public Scheduler getScheduler() {
                return AndroidSchedulers.mainThread();
            }
        });
    }

    @Override
    public void setView(CityForecastView view) {
        forecastView = view;
    }

    @Override
    public void create() {
        CityEntity paris = CityEntity.paris();
        double lat = paris.getCoordinates().getLatitude();
        double lon = paris.getCoordinates().getLongitude();
        forcastByCoordinatesUseCase.execute(new DisposableObserver<Forecast>() {
            @Override
            public void onNext(Forecast forecast) {
                forecastView.hideLoading();
                forecastView.renderForecast(PresentationModelMapper.transform(forecast));
            }

            @Override
            public void onError(Throwable e) {
                Log.e(CityForecastPresenter.class.getSimpleName(), "forcastByCoordinatesUseCase.execute", e);
                forecastView.hideLoading();
                forecastView.showError(ErrorMessageFactory.create(forecastView.context(), e));
            }

            @Override
            public void onComplete() {

            }
        }, GetForcastByCoordinates.Params.forCoordinates(lat, lon));
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        this.forcastByCoordinatesUseCase.dispose();
        this.forecastView = null;
    }
}
