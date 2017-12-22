package pl.allegier.controller.frontend.mapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

@Component
public class AccountMapper implements Mapper<AccountDto, Account> {

    private static final Logger LOGGER = Logger.getLogger(AccountMapper.class);

    @Autowired
    private TimestampMapper timestampMapper;

    private AddressMapper addressMapper = new AddressMapper();

    @Override
    public final Account toDao(final AccountDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("AccountDto cannot be null");
        }

        Account account = new Account();
        account.setId(dto.getId());
        account.setLogin(dto.getLogin());
        account.setPassword(dto.getPassword());
        account.setAddress(addressMapper.toDao(dto.getAddressDto()));

        timestampMapper.toDao(account, dto);

        return account;
    }

    @Override
    public final AccountDto toDto(final Account account) {
        if (account == null) {
            throw new IllegalArgumentException("account cannot be null");
        }

        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setLogin(account.getLogin());
        dto.setPassword(account.getPassword());
        dto.setAddressDto(addressMapper.toDto(account.getAddress()));

        timestampMapper.toDto(dto, account);

        return dto;
    }

}

