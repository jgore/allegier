package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.model.id.IIdentifable;
import pl.allegier.model.timestamp.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | GoreIT on 03.04.17.
 */

@Entity
@Table(name = "ACCOUNTS")
public class Account extends Timestamp implements IIdentifable<Integer>, Serializable {

    private static final long serialVersionUID = 1538176138199455942L;

    private Integer id;

    private String login;
    private String password;

    private Set<Order> orders;
    private Address address = new Address();

    public Account(final String login, final String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public Account() {
    }

    @Id
    @GeneratedValue
    @Override
    public final Integer getId() {
        return id;
    }

    @Column(nullable = false, unique = true)
    public final String getLogin() {
        return login;
    }

    @Column(nullable = false)
    public final String getPassword() {
        return password;
    }

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    public final Set<Order> getOrders() {
        return orders;
    }

    @Embedded
    public final Address getAddress() {
        return address;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final void setLogin(final String login) {
        this.login = login;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    public final void setAddress(final Address address) {
        this.address = address;
    }

    public final void setOrders(final Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Account))
            return false;
        Account account = (Account) o;
        return Objects.equals(getLogin(), account.getLogin()) && Objects.equals(getPassword(), account.getPassword()) && Objects
                .equals(getOrders(), account.getOrders()) && Objects.equals(getAddress(), account.getAddress())
                && Objects.equals(getCreated(), account.getCreated()) && Objects.equals(getUpdated(), account.getUpdated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getOrders(), getAddress(), getCreated(), getUpdated());
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
