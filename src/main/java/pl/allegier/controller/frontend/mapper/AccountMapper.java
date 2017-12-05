package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.model.Account;

import javax.transaction.Transactional;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

@Component
public class AccountMapper implements Mapper<AccountDto, Account>{

    @Autowired
    private AllegierModelMapper mapper;

    @Transactional
    @Override
    public Account toDao(final AccountDto dto) {
        if( dto == null)
        {
            throw new IllegalArgumentException("Account cannot be null");
        }
        return mapper.map(dto, Account.class);
    }

    @Override
    public final AccountDto toDto(final Account dao) {
        if( dao == null)
        {
            throw new IllegalArgumentException("Account cannot be null");
        }
        return mapper.map(dao, AccountDto.class);
    }

}

