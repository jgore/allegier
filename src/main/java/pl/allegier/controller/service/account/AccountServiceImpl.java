package pl.allegier.controller.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegier.controller.repository.AccountRepository;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | Satlan on 03.04.17.
 */

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public <S extends Account> S save(S Account ) {
        return accountRepository.save( Account );
    }

    @Override
    public <S extends Account> Iterable<S> save(Iterable<S> accounts) {
        return accountRepository.save(accounts);
    }

    @Override
    public Account findOne(Integer id) {
        return accountRepository.findOne( id );
    }

    @Override
    public boolean exists(Integer id) {
        return accountRepository.exists( id );
    }

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Iterable<Account> findAll(Iterable<Integer> ids) {
        return accountRepository.findAll( ids );
    }

    @Override
    public long count() {
        return accountRepository.count();
    }

    @Override
    public void delete(Integer id) {
        accountRepository.delete( id );
    }

    @Override
    public void delete(Iterable<? extends Account> Accounts) {
        accountRepository.delete( Accounts );
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
