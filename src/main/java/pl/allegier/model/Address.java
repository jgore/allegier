package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Embeddable;

/**
 * Created by Pawel Szczepkowski | Satlan on 25.07.17.
 */

@Embeddable
public class Address {

    private String streetName;
    private int streetNumber;
    private int localeNumber;
    private String zipCode;
    private String city;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getLocaleNumber() {
        return localeNumber;
    }

    public void setLocaleNumber(int localeNumber) {
        this.localeNumber = localeNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
