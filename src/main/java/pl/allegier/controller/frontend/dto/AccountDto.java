package pl.allegier.controller.frontend.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Pawel Szczepkowski | GoreIT on 13.04.17.
 */

public class AccountDto extends TimeStampDto implements Serializable {

    private static final long serialVersionUID = 2163332914760385642L;

    private Integer id;

    private String login;
    private String password;

    public AccountDto(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public AccountDto() {
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }


    public final String getLogin() {
        return login;
    }

    public final void setLogin(final String login) {
        this.login = login;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
