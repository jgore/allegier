package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.model.Account;

import javax.transaction.Transactional;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

@Component
public class AccountMapper implements Mapper<AccountDto,Account>{

    private static final ModelMapper mapper = new ModelMapper();

    @Transactional
    public Account toDao(AccountDto dto) {
        if( dto == null)
        {
            throw new IllegalArgumentException("Account cannot be null");
        }
        return mapper.map(dto, Account.class);
    }

    public AccountDto toDto(Account dao) {
        if( dao == null)
        {
            throw new IllegalArgumentException("Account cannot be null");
        }
        return mapper.map(dao, AccountDto.class);
    }

}

