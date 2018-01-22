package com.medhdj.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by medhdj on 22.01.18.
 */

public class ForecastEntity {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;

    @SerializedName("coord")
    @Expose
    private CoordinatesEntity coordinates;

    @SerializedName("weather")
    @Expose
    private List<WeatherEntity> weather = null;

    @SerializedName("base")
    @Expose
    private String base;

    @SerializedName("visibility")
    @Expose
    private Integer visibility;

    @SerializedName("dt")
    @Expose
    private Integer dt;

    @Expose
    private long temperature;


    public CoordinatesEntity getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesEntity coordinates) {
        this.coordinates = coordinates;
    }

    public List<WeatherEntity> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherEntity> weather) {
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

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("cod", cod)
                .append("name", name)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dt)
                .append(id)
                .append(cod)
                .append(name)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ForecastEntity) == false) {
            return false;
        }
        ForecastEntity rhs = ((ForecastEntity) other);
        return new EqualsBuilder()
                .append(id, rhs.id)
                .append(name, rhs.name)
                .isEquals();
    }

}