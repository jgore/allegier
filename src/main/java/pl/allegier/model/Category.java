package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.model.id.IIdentifable;
import pl.allegier.model.timestamp.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
public class Category extends Timestamp implements IIdentifable<String>, Serializable {

    private static final long serialVersionUID = 7389463192547585546L;

    private String id;
    private Set<AbstractProduct> products;

    @Id
    public final String getId() {
        return id;
    }

    @OneToMany(mappedBy = "category")
    public final Set<AbstractProduct> getProducts() {
        return products;
    }

    @Override
    public final void setId(final String id) {
        this.id = id;
    }

    public final void setProducts(final Set<AbstractProduct> products) {
        this.products = products;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Category))
            return false;
        Category category = (Category) o;
        return Objects.equals(getId(), category.getId())
                && Objects.equals(getProducts(), category.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProducts());
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
