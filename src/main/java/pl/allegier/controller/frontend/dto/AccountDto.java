package pl.allegier.controller.frontend.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Pawel Szczepkowski | Satlan on 13.04.17.
 */

public class AccountDto implements Serializable {

    private static final long serialVersionUID = 2163332914760385642L;

    private Integer id;

    private String login;
    private String password;

    public AccountDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AccountDto() {
    }

    private Date created;
    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
