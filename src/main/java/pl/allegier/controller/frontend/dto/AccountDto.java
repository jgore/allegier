package pl.allegier.controller.frontend.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.model.id.IIdentifable;

import java.io.Serializable;

/**
 * Created by Pawel Szczepkowski | GoreIT on 13.04.17.
 */

public class AccountDto extends BaseDto implements Serializable, IIdentifable<Integer> {

    private static final long serialVersionUID = 2163332914760385642L;

    private Integer id;

    private String login;
    private String password;

    private AddressDto addressDto;

    public AccountDto(final String log, final String pass) {
        this.login = log;
        this.password = pass;
    }

    public AccountDto() {
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer idArg) {
        this.id = idArg;
    }

    public final String getLogin() {
        return login;
    }

    public final void setLogin(final String log) {
        this.login = log;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(final String pass) {
        this.password = pass;
    }

    public final AddressDto getAddressDto() {
        return addressDto;
    }

    public final void setAddressDto(final AddressDto dto) {
        this.addressDto = dto;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
