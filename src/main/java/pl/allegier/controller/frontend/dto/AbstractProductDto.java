package pl.allegier.controller.frontend.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
public class AbstractProductDto extends TimeStampDto implements Serializable {

    private static final long serialVersionUID = 6534533311682850417L;

    private Integer id;
    private String category;

    private String title;
    private String description;

    private BigDecimal price;

    public AbstractProductDto(final String title, final String description, final BigDecimal price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public AbstractProductDto() {
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getCategory() {
        return category;
    }

    public final void setCategory(final String category) {
        this.category = category;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    public final BigDecimal getPrice() {
        return price;
    }

    public final void setPrice(final BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
