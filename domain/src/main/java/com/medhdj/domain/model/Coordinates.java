package com.medhdj.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by medhdj on 22.01.18.
 */

public class Coordinates {
    private Double longitude;
    private Double latitude;

    public Coordinates(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        return new EqualsBuilder()
                .append(longitude, that.longitude)
                .append(latitude, that.latitude)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(longitude)
                .append(latitude)
                .toHashCode();
    }
}
