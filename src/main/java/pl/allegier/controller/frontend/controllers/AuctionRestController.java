package pl.allegier.controller.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allegier.controller.frontend.dto.AuctionDto;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.controller.frontend.service.auction.AuctionFrontService;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */

@RestController
@RequestMapping("rest/auctions")
public class AuctionRestController extends AbstractRestController<AuctionDto,Integer> {

    @Autowired
    private AuctionFrontService auctionFrontService;


    @Override
    public FrontService<AuctionDto, Integer> getFrontService() {
        return auctionFrontService;
    }
}
