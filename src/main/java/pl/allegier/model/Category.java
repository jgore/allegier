package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Identifable<String>, Serializable {

    private static final long serialVersionUID = 7389463192547585546L;

    private String id;
    private Set<AbstractProduct> products;

    private Date created;
    private Date updated;

    @Id
    public String getId() {
        return id;
    }

    @OneToMany(mappedBy = "category")
    public Set<AbstractProduct> getProducts() {
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

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void setProducts(Set<AbstractProduct> products)

    {
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
