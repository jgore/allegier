package pl.allegier.controller.frontend.dto;

import pl.allegier.model.Identifable;

import java.io.Serializable;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */
public class AuctionDto extends ProductDto implements Serializable,Identifable<Integer> {
    private static final long serialVersionUID = 1552366802875767338L;


}
