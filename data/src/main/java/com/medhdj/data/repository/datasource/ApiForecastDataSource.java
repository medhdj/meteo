package com.medhdj.data.repository.datasource;

import com.medhdj.data.entity.ForecastEntity;
import com.medhdj.data.repository.datasource.remote.RestApi;

import io.reactivex.Observable;

/**
 * Created by medhdj on 22/01/2018.
 */

public class ApiForecastDataSource implements ForecastDataSource {
    private final RestApi restApi;

    public ApiForecastDataSource() {
        restApi = RestApi.Factory.createService();
    }

    @Override
    public Observable<ForecastEntity> forcastByCoordinates(double lat, double lon) {
        return restApi.forcastByCoordinates(lat, lon);
    }
}
