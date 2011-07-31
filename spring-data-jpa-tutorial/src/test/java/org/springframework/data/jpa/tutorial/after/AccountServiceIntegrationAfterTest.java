package org.springframework.data.jpa.tutorial.after;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.tutorial.before.CustomerService;
import org.springframework.data.jpa.tutorial.core.AbstractTutorialTest;
import org.springframework.data.jpa.tutorial.core.Account;
import org.springframework.data.jpa.tutorial.core.Customer;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration({"classpath:application-context-after.xml"})
public class AccountServiceIntegrationAfterTest extends AbstractTutorialTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerService customerService;


    @Test
    public void testname() throws Exception {

        assertNotNull("accountService should be wired", accountRepository);
        assertNotNull("customerService should be wired", customerService);
        Customer customer = customerService.findById(1L);

        List<Account> accounts = accountRepository.findByCustomer(customer);

        assertFalse(accounts.isEmpty());
        assertThat(accounts.get(0).getCustomer(), is(customer));
    }

}
