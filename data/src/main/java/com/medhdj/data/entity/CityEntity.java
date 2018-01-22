package com.medhdj.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by medhdj on 22.01.18.
 */

public class CityEntity {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("coordinates")
    @Expose
    private CoordinatesEntity coordinates;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CoordinatesEntity getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesEntity coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("country", country)
                .append("coordinates", coordinates).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CityEntity) == false) {
            return false;
        }
        CityEntity rhs = ((CityEntity) other);
        return new EqualsBuilder()
                .append(id, rhs.id)
                .isEquals();
    }

    //for sample purpose
    public static CityEntity paris() {
        CityEntity paris = new CityEntity();
        paris.setId(2978048);
        paris.setCoordinates(new CoordinatesEntity(48.864716, 2.349014));
        paris.setCountry("France");
        paris.setName("Paris");
        return paris;
    }

}

