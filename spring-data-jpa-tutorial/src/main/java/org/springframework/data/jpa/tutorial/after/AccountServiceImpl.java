package org.springframework.data.jpa.tutorial.after;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.tutorial.before.AccountService;
import org.springframework.data.jpa.tutorial.core.Account;
import org.springframework.data.jpa.tutorial.core.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Plain JPA implementation of {@link AccountService}.
 * 
 * @author Oliver Gierke
 */
@Repository
class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Account> findByCustomer(Customer customer) {
        return accountRepository.findByCustomer(customer);
    }
}
