package pl.allegier.it.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.controller.frontend.dto.AuctionDto;
import pl.allegier.controller.frontend.dto.BidDto;
import pl.allegier.controller.frontend.service.account.AccountFrontService;
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
public class AuctionsWithBidsIT {

    private static final String TEST_TITLE = "title";
    private static final String TEST_DESC = "desc";

    @Autowired
    private AuctionFrontService auctionFrontService;

    @Autowired
    private AccountFrontService accountFrontService;

    @Test
    public void createManyAuctions()
    {
        int length = MainCategoryName.values().length;
        Random random = new Random();

        for( int i=0;i<100;i++)
        {
            AuctionDto auctionDto= new AuctionDto();
            auctionDto.setTitle(TEST_TITLE);
            auctionDto.setDescription(TEST_DESC);
            auctionDto.setPrice(BigDecimal.ONE);
            auctionDto.setCategoryId( MainCategoryName.values()[random.nextInt(length)].name() );
            auctionDto  = auctionFrontService.save(auctionDto);

            AccountDto accountDto = new AccountDto();
            accountDto.setLogin("1234");
            accountDto = accountFrontService.save(accountDto);

            BidDto bidDto= new BidDto();
            bidDto.setAccountId(accountDto.getId());
            bidDto.setAuctionId(auctionDto.getId());
            bidDto.setPrice(BigDecimal.ONE);

            auctionFrontService.addBid(auctionDto.getId(), bidDto );

        }
    }
}
