package com.medhdj.domain.repository;

import com.medhdj.domain.model.Coordinates;
import com.medhdj.domain.model.Forecast;

import io.reactivex.Observable;

/**
 * Created by medhdj on 22.01.18.
 */

public interface ForecastRepository {
    Observable<Forecast> forcastByCoordinates(Coordinates coordinates);
}
