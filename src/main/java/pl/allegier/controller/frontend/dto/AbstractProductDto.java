package pl.allegier.controller.frontend.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
public class AbstractProductDto extends TimeStampDto implements Serializable{

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

    public final void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
