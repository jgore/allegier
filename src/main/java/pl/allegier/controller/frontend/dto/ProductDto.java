package pl.allegier.controller.frontend.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
public class ProductDto extends AbstractProductDto implements Serializable {

    private static final long serialVersionUID = 7410956460083426518L;

    public ProductDto(final String title, final String description, final BigDecimal price) {
        super(title, description, price);
    }

    public ProductDto() {
    }
}

