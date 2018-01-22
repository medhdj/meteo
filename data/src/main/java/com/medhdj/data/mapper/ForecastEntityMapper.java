package com.medhdj.data.mapper;

import com.medhdj.data.entity.CityEntity;
import com.medhdj.data.entity.ForecastEntity;
import com.medhdj.data.entity.WeatherEntity;
import com.medhdj.domain.model.City;
import com.medhdj.domain.model.Coordinates;
import com.medhdj.domain.model.Forecast;
import com.medhdj.domain.model.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by medhdj on 22.01.18.
 */

public class ForecastEntityMapper {
    public static Forecast transform(ForecastEntity forecastEntity) {
        Forecast.Builder forecastBuilder = new Forecast.Builder();
        forecastBuilder
                .withId(forecastEntity.getId())
                .withName(forecastEntity.getName())
                .withCod(forecastEntity.getCod())
                .withBase(forecastEntity.getBase())
                .withDt(forecastEntity.getDt())
                .withTemperature(forecastEntity.getTemperature());

        List<Weather> weathers = new ArrayList<>();
        for (WeatherEntity weatherEntity : forecastEntity.getWeather()) {
            Weather weather = new Weather();
            weather.setId(weatherEntity.getId());
            weather.setMain(weatherEntity.getMain());
            weather.setDescription(weatherEntity.getDescription());
            weather.setIcon(weatherEntity.getIcon());

            weathers.add(weather);
        }

        forecastBuilder.withWeather(weathers);

        Coordinates coordinates = new Coordinates(forecastEntity.getCoordinates().getLatitude(),
                forecastEntity.getCoordinates().getLongitude());
        forecastBuilder.withCoordinates(coordinates);

        CityEntity cityEntity = CityEntity.paris();
        City city = new City();
        city.setId(cityEntity.getId());
        city.setCountry(cityEntity.getCountry());
        city.setName(cityEntity.getName());

        forecastBuilder.withCity(city);

        return forecastBuilder.build();
    }
}