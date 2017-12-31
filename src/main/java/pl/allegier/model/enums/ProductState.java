package pl.allegier.model.enums;

/**
 * @author Pawel Szczepkowski | GoreIT on 18.04.17.
 */
public enum ProductState {
    /**
     * ACTIVE when product is just created
     *
     */
    ACTIVE,

    /**
     * When is deleted. Product has to persist in db because of old orders and complaint time.
     */

    DELETED
}
