package org.springframework.data.jpa.tutorial.before;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.tutorial.before.AccountService;
import org.springframework.data.jpa.tutorial.before.CustomerService;
import org.springframework.data.jpa.tutorial.core.Account;
import org.springframework.data.jpa.tutorial.core.Customer;
import org.springframework.data.jpa.tutorial.core.AbstractTutorialTest;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration("classpath:application-context-before.xml")
public class AccountServiceIntegrationTest extends AbstractTutorialTest {

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;


    @Test
    public void testname() throws Exception {

        Customer customer = customerService.findById(1L);

        List<Account> accounts = accountService.findByCustomer(customer);

        assertFalse(accounts.isEmpty());
        assertThat(accounts.get(0).getCustomer(), is(customer));
    }

}
