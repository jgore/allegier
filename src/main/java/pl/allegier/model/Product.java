package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    private static final long serialVersionUID = 187171862135038178L;


    private Integer id;

    private String title;
    private String description;

    private BigDecimal price;

    private Date created;
    private Date updated;

    public Product(String title, String description, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    @Id
    @GeneratedValue
    @Column
    public Integer getId() {
        return id;
    }

    @Column
    public String getTitle() {
        return title;
    }

    @Column
    public String getDescription() {
        return description;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }


    @CreationTimestamp
    @Column(updatable=false)
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(title, product.title) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price);
    }

    @Override
    public String toString()
    {
       return ReflectionToStringBuilder.toString(this);
    }
}
