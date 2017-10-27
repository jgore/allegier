package pl.allegier.controller.frontend.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.model.Account;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class AccountMapperTest implements MapperTest<AccountDto,Account>{

    private static final String TEST_LOGIN_1 = "gore";
    private static final String TEST_LOGIN_2 = "gore1234";
    private static final String TEST_PASSWORD = "1234";

    @Autowired
    private Mapper<AccountDto,Account> accountMapper;

    @Test
    public void toEntityTest()
    {
        AccountDto dto = new AccountDto(TEST_LOGIN_1, TEST_PASSWORD);
        Account dao = accountMapper.toDao(dto);

        assertThat( dto.getLogin(), equalTo( dao.getLogin()) );
        assertThat( dto.getPassword(), equalTo( dao.getPassword()) );
    }

    @Test
    public void toDtoTest()
    {
        AccountDto dto = new AccountDto(TEST_LOGIN_1, TEST_PASSWORD);
        Account dao = accountMapper.toDao(dto);

        assertThat( dto.getLogin(), equalTo( dao.getLogin()) );
        assertThat( dto.getPassword(), equalTo( dao.getPassword()) );
    }

}