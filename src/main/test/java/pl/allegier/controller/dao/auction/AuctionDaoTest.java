package pl.allegier.controller.dao.auction;

import com.google.common.collect.Sets;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.account.AccountDao;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.model.Account;
import pl.allegier.model.Auction;
import pl.allegier.model.Bid;
import pl.allegier.model.Category;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */
@Component
public class AuctionDaoTest extends AbstractDaoTest<Auction, Integer> implements DaoTest<Auction,Integer> {

    public static final String TEST_PROD_TITLE_1 = " TEST _ PROD _ TITLE 1";
    public static final String TEST_PROD_TITLE_2 = " TEST _ PROD _ TITLE 2";
    public static final String TEST_DESCRIPTION = " TEST _ PROD _ DESC ";
    public static final BigDecimal TEST_PRICE = BigDecimal.valueOf(123);

    @Autowired
    private AuctionDao auctionDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private AccountDao accountDao;

    @After
    @Override
    public void cleanUp()
    {
        auctionDao.removeAll();
        categoryDao.removeAll();
        accountDao.removeAll();
    }

    @Override
    public Dao<Auction, Integer> getRepository() {
        return auctionDao;
    }

    @Test
    public void addBidShouldAddBidToAuction()
    {
        Account account = new Account();
        account.setLogin("1234");
        account = accountDao.save(account);
        account = accountDao.findById(account.getId());

        Auction auction = createEntity();

        Auction save = auctionDao.save(auction);

        Bid bid = new Bid();
        bid.setAccount(account);
        bid.setAuction( auction);

        auction.setBids( Sets.newHashSet(bid) );

        Auction persisted = auctionDao.update(save );

        assertThat( persisted.getBids().size(), equalTo(1));
    }

    @Override
    public Auction createEntity() {
        Auction product = new Auction(TEST_PROD_TITLE_1, TEST_DESCRIPTION, TEST_PRICE);
        Category category = createCategory();
        Category save = categoryDao.save(category);
        product.setCategory(save);
        return product;
    }

    public Category createCategory()
    {
        Category category = new Category();
        category.setId("1234");

        return category;
    }
}