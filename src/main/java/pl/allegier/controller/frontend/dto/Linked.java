package pl.allegier.controller.frontend.dto;

/**
 * Linked is can be added for exmaple to DTO's  to save source link
 */
public interface Linked {

    /**
     * get for link
     *
     * @return link
     */
     String getLink();

    /**
     *
     * @param link link
     */
     void setLink(String link);
}
