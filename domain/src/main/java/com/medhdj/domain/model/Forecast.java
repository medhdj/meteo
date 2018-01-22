package com.medhdj.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

/**
 * Created by medhdj on 22.01.18.
 */

public class Forecast {
    private Integer id;
    private String name;
    private Integer cod;
    private Coordinates coordinates;
    private City city;
    private List<Weather> weather;
    private String base;
    private Integer visibility;
    private Integer dt;
    private long temperature;

    private Forecast(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setCod(builder.cod);
        setCoordinates(builder.coordinates);
        setCity(builder.city);
        setWeather(builder.weather);
        setBase(builder.base);
        setVisibility(builder.visibility);
        setDt(builder.dt);
        setTemperature(builder.temperature);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Forecast forecast = (Forecast) o;

        return new EqualsBuilder()
                .append(id, forecast.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private Integer cod;
        private Coordinates coordinates;
        private City city;
        private List<Weather> weather;
        private String base;
        private Integer visibility;
        private Integer dt;
        private long temperature;

        public Builder() {
        }

        public Builder withId(Integer val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withCod(Integer val) {
            cod = val;
            return this;
        }

        public Builder withCoordinates(Coordinates val) {
            coordinates = val;
            return this;
        }

        public Builder withCity(City val) {
            city = val;
            return this;
        }

        public Builder withWeather(List<Weather> val) {
            weather = val;
            return this;
        }

        public Builder withBase(String val) {
            base = val;
            return this;
        }

        public Builder withVisibility(Integer val) {
            visibility = val;
            return this;
        }

        public Builder withDt(Integer val) {
            dt = val;
            return this;
        }

        public Builder withTemperature(long val) {
            temperature = val;
            return this;
        }

        public Forecast build() {
            return new Forecast(this);
        }
    }
}
