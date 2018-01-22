package com.medhdj.domain.usecase;

import com.medhdj.domain.executor.PostExecutionThread;
import com.medhdj.domain.model.Coordinates;
import com.medhdj.domain.model.Forecast;
import com.medhdj.domain.repository.ForecastRepository;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by medhdj on 22/01/2018.
 */

public class GetForcastByCoordinates extends UseCase<Forecast, GetForcastByCoordinates.Params> {
    private final ForecastRepository forecastRepository;
    private final PostExecutionThread postExecutionThread;

    public GetForcastByCoordinates(ForecastRepository forecastRepository,
                                   PostExecutionThread postExecutionThread) {
        this.forecastRepository = forecastRepository;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    Observable<Forecast> buildUseCaseObservable(Params params) {
        return forecastRepository
                .forcastByCoordinates(params.coordinates)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.getScheduler());
    }


    public static final class Params {
        private final Coordinates coordinates;

        private Params(Coordinates coordinates) {
            this.coordinates = coordinates;
        }

        public static Params forCoordinates(double lat, double lon) {
            Coordinates coordinates = new Coordinates(lat, lon);
            return new Params(coordinates);
        }
    }
}
