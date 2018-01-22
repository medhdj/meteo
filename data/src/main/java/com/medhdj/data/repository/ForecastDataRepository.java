package com.medhdj.data.repository;


import com.medhdj.data.entity.ForecastEntity;
import com.medhdj.data.mapper.ForecastEntityMapper;
import com.medhdj.data.repository.datasource.ApiForecastDataSource;
import com.medhdj.data.repository.datasource.ForecastDataSource;
import com.medhdj.domain.model.Coordinates;
import com.medhdj.domain.model.Forecast;
import com.medhdj.domain.repository.ForecastRepository;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by medhdj on 22.01.18.
 */

public class ForecastDataRepository implements ForecastRepository {
    private final ForecastDataSource dataSource;

    public ForecastDataRepository() {
        dataSource = new ApiForecastDataSource();
    }

    @Override
    public Observable<Forecast> forcastByCoordinates(Coordinates coordinates) {
        return dataSource
                .forcastByCoordinates(coordinates.getLatitude(), coordinates.getLongitude())
                .map(new Function<ForecastEntity, Forecast>() {
                    @Override
                    public Forecast apply(ForecastEntity forecastEntity) throws Exception {

                        return ForecastEntityMapper.transform(forecastEntity);
                    }
                });
    }
}
