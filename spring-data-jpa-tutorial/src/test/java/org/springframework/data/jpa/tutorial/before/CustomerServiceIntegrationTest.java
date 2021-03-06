package org.springframework.data.jpa.tutorial.before;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.tutorial.core.AbstractTutorialTest;
import org.springframework.data.jpa.tutorial.core.Customer;
import org.springframework.test.context.ContextConfiguration;


/**
 * @author Oliver Gierke
 */
@ContextConfiguration("classpath:application-context-before.xml")
public class CustomerServiceIntegrationTest extends AbstractTutorialTest {

    @Autowired
    CustomerService repository;


    @Test
    public void findsAllCustomers() throws Exception {

        Iterable<Customer> result = repository.findAll();

        assertThat(result, is(notNullValue()));
        assertTrue(result.iterator().hasNext());
    }


    @Test
    public void findsPageOfMatthews() throws Exception {

        List<Customer> customers = repository.findByLastname("Matthews", 0, 2);

        assertThat(customers.size(), is(2));
    }


    @Test
    public void findsCustomerById() throws Exception {

        Customer customer = repository.findById(2L);

        assertThat(customer.getFirstname(), is("Carter"));
        assertThat(customer.getLastname(), is("Beauford"));
    }
}
