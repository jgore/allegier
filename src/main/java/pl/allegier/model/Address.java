package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Pawel Szczepkowski | GoreIT on 25.07.17.
 */

@Embeddable
public class Address implements Serializable{

    private static final long serialVersionUID = 2538176138199455942L;

    private String streetName;
    private int streetNumber;
    private int localeNumber;
    private String zipCode;
    private String city;

    @Column
    public final String getStreetName() {
        return streetName;
    }

    @Column
    public final int getStreetNumber() {
        return streetNumber;
    }

    @Column
    public final int getLocaleNumber() {
        return localeNumber;
    }

    @Column
    public final String getZipCode() {
        return zipCode;
    }

    @Column
    public final String getCity() {
        return city;
    }

    public final void setStreetName(final String streetName) {
        this.streetName = streetName;
    }

    public final void setStreetNumber(final int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public final void setLocaleNumber(final int localeNumber) {
        this.localeNumber = localeNumber;
    }

    public final void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public final void setCity(final String city) {
        this.city = city;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getStreetNumber() == address.getStreetNumber()
                && getLocaleNumber() == address.getLocaleNumber()
                && Objects.equals(getStreetName(), address.getStreetName())
                && Objects.equals(getZipCode(), address.getZipCode())
                && Objects.equals(getCity(), address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreetName(), getStreetNumber(), getLocaleNumber(), getZipCode(), getCity());
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
