package pl.allegier.it.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.controller.frontend.dto.AuctionDto;
import pl.allegier.controller.frontend.service.auction.AuctionFrontService;
import pl.allegier.it.ItConfiguration;
import pl.allegier.model.enums.MainCategoryName;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ItConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class AuctionsIT {

    private static final String TEST_TITLE = "title";
    private static final String TEST_DESC = "desc";

    @Autowired
    private AuctionFrontService auctionFrontService;

    @Test
    public void createManyAuctions()
    {
        int length = MainCategoryName.values().length;
        Random random = new Random();

        for( int i=0;i<100;i++)
        {
            AuctionDto dto= new AuctionDto();
            dto.setTitle(TEST_TITLE);
            dto.setDescription(TEST_DESC);
            dto.setPrice(BigDecimal.ONE);
            dto.setCategoryId( MainCategoryName.values()[random.nextInt(length)].name() );
            auctionFrontService.save( dto );
        }
    }
}
