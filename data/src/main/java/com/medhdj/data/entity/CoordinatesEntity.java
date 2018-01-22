package com.medhdj.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by medhdj on 22.01.18.
 */

public class CoordinatesEntity {
    @SerializedName("lon")
    @Expose
    private Double longitude;

    @SerializedName("lat")
    @Expose
    private Double latitude;

    public CoordinatesEntity(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
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
    public String toString() {
        return new ToStringBuilder(this)
                .append("longitude", longitude)
                .append("latitude", latitude)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(longitude)
                .append(latitude)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CoordinatesEntity) == false) {
            return false;
        }
        CoordinatesEntity rhs = ((CoordinatesEntity) other);
        return new EqualsBuilder()
                .append(longitude, rhs.longitude)
                .append(latitude, rhs.latitude)
                .isEquals();
    }
}
