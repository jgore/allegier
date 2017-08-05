package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Identifable<Integer>, Serializable {

    private static final long serialVersionUID = 7389463192547585546L;

    private Integer id;

    private String name;
    private Set<Product> products;

    private Date created;
    private Date updated;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "category")
    public Set<Product> getProducts() {
        return products;
    }

    @CreationTimestamp
    @Column
    public Date getCreated() {
        return created;
    }

    @UpdateTimestamp
    @Column
    public Date getUpdated() {
        return updated;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
