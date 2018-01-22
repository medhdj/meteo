package com.medhdj.samples.meteo.model;

/**
 * Created by mohamed on 22/01/2018.
 */

public class ForecastVM {
    // must not do this in a prod app !
    private static String OPEN_WEATHER_ICONS_URL = "http://openweathermap.org/img/w/";
    private static String OPEN_WEATHER_ICONS_EXTENSION = ".png";

    String cityName;
    String forecastDate;
    String weatherIcon;
    String weatherLabel;
    String temperature;

    private ForecastVM(Builder builder) {
        cityName = builder.cityName;
        forecastDate = builder.forecastDate;
        weatherIcon = builder.weatherIcon;
        weatherLabel = builder.weatherLabel;
        temperature = builder.temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public String getForecastDate() {
        return forecastDate;
    }

    public String getWeatherIcon() {
        return OPEN_WEATHER_ICONS_URL + weatherIcon + OPEN_WEATHER_ICONS_EXTENSION;
    }

    public String getWeatherLabel() {
        return weatherLabel;
    }

    public String getTemperature() {
        return temperature;
    }

    public static final class Builder {
        private String cityName;
        private String forecastDate;
        private String weatherIcon;
        private String weatherLabel;
        private String temperature;

        public Builder() {
        }

        public Builder withCityName(String val) {
            cityName = val;
            return this;
        }

        public Builder withForecastDate(String val) {
            forecastDate = val;
            return this;
        }

        public Builder withWeatherIcon(String val) {
            weatherIcon = val;
            return this;
        }

        public Builder withWeatherLabel(String val) {
            weatherLabel = val;
            return this;
        }

        public Builder withTemperature(String val) {
            temperature = val;
            return this;
        }

        public ForecastVM build() {
            return new ForecastVM(this);
        }
    }
}
