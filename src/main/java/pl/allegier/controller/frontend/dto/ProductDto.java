package pl.allegier.controller.frontend.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
public class ProductDto extends AbstractProductDto implements Serializable {

    public ProductDto(String title, String description, BigDecimal price) {
        super(title, description, price);
    }

    public ProductDto() {
    }

    private static final long serialVersionUID = 7410956460083426518L;

}

