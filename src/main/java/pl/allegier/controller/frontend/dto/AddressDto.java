package pl.allegier.controller.frontend.dto;

public class AddressDto {

    private String streetName;
    private int streetNumber;
    private int localeNumber;
    private String zipCode;
    private String city;

    public final String getStreetName() {
        return streetName;
    }

    public final void setStreetName(final String streetName) {
        this.streetName = streetName;
    }

    public final int getStreetNumber() {
        return streetNumber;
    }

    public final void setStreetNumber(final int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public final int getLocaleNumber() {
        return localeNumber;
    }

    public final void setLocaleNumber(final int localeNumber) {
        this.localeNumber = localeNumber;
    }

    public final String getZipCode() {
        return zipCode;
    }

    public final void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public final String getCity() {
        return city;
    }

    public final void setCity(final String city) {
        this.city = city;
    }
}
