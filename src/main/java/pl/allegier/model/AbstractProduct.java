package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.model.enums.ProductState;
import pl.allegier.model.id.IIdentifable;
import pl.allegier.model.timestamp.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    private ProductState state;

    private String title;
    private String description;

    private BigDecimal price;

    public AbstractProduct(final String titleArg, final String desc, final BigDecimal priceArg) {
        this.title = titleArg;
        this.description = desc;
        this.price = priceArg;
        this.state = ProductState.ACTIVE;
    }

    public AbstractProduct() {
        this.state = ProductState.ACTIVE;
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

    @Enumerated(value = EnumType.STRING)
    public final ProductState getState() {
        return state;
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

    public final void setState(final ProductState state) {
        this.state = state;
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
