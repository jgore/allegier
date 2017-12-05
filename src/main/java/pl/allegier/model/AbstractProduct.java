package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.model.id.IIdentifable;
import pl.allegier.model.timestamp.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractProduct extends Timestamp implements Serializable, IIdentifable<Integer> {

    private static final long serialVersionUID = 8879554901850384465L;

    private Integer id;

    private Category category;

    private String title;
    private String description;

    private BigDecimal price;

    public AbstractProduct(final String title, final String description, final BigDecimal price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public AbstractProduct() {
    }

    @Id
    @GeneratedValue
    public final Integer getId() {
        return id;
    }

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", nullable = false)
    public final Category getCategory() {
        return category;
    }

    @Column
    public final String getTitle() {
        return title;
    }

    @Column
    public final String getDescription() {
        return description;
    }

    @Column
    public final BigDecimal getPrice() {
        return price;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final void setCategory(final Category category) {
        this.category = category;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    public final void setPrice(final BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
