package com.medhdj.samples.meteo.mapper;

import android.support.annotation.NonNull;

import com.medhdj.domain.model.Forecast;
import com.medhdj.samples.meteo.DateUtils;
import com.medhdj.samples.meteo.model.ForecastVM;

/**
 * Created by mohamed on 22/01/2018.
 */

public class PresentationModelMapper {
    public static ForecastVM transform(@NonNull Forecast forecast) {
        if (forecast == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final ForecastVM.Builder forcastBuilder = new ForecastVM.Builder();
        forcastBuilder
                .withCityName(forecast.getCity().getName())
                .withForecastDate(DateUtils.formatDate(forecast.getDt()))
                .withWeatherIcon(forecast.getWeather().get(0).getIcon())
                .withWeatherLabel(forecast.getWeather().get(0).getMain())
                .withTemperature(String.valueOf(forecast.getTemperature()) + " °C");

        return forcastBuilder.build();
    }

}
