package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
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

    @Column
    public String getStreetName() {
        return streetName;
    }

    @Column
    public int getStreetNumber() {
        return streetNumber;
    }

    @Column
    public int getLocaleNumber() {
        return localeNumber;
    }

    @Column
    public String getZipCode() {
        return zipCode;
    }

    @Column
    public String getCity() {
        return city;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setLocaleNumber(int localeNumber) {
        this.localeNumber = localeNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
