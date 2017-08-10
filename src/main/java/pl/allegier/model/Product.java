package pl.allegier.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product extends AbstractProduct {

    private static final long serialVersionUID = 6420253915164168565L;

    public Product(String title, String description, BigDecimal price) {
        super(title, description, price);
    }

    public Product() {
    }


}
