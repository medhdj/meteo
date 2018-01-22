package com.medhdj.data.repository.datasource;

import com.medhdj.data.entity.ForecastEntity;

import io.reactivex.Observable;

/**
 * Created by medhdj on 22/01/2018.
 */

public interface ForecastDataSource {
    Observable<ForecastEntity> forcastByCoordinates(double lat, double lon);
}
