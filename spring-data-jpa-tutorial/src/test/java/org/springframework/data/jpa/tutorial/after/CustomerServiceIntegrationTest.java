package org.springframework.data.jpa.tutorial.after;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.tutorial.core.AbstractTutorialTest;
import org.springframework.data.jpa.tutorial.core.Customer;
import org.springframework.test.context.ContextConfiguration;


/**
 * @author Oliver Gierke
 */
@ContextConfiguration("classpath:application-context-after.xml")
public class CustomerServiceIntegrationTest extends AbstractTutorialTest {

    @Autowired
    CustomerRepository repository;


    @Test
    public void findsAllCustomers() throws Exception {

        Iterable<Customer> result = repository.findAll();

        assertThat(result, is(notNullValue()));
        assertTrue(result.iterator().hasNext());
    }


    @Test
    public void findsPageOfMatthews() throws Exception {

        Page<Customer> customers = repository.findByLastname("Matthews", new PageRequest(0, 2));

        assertThat(customers.getContent().size(), is(2));
    }


    @Test
    public void findsCustomerById() throws Exception {

        Customer customer = repository.findOne(2L);

        assertThat(customer.getFirstname(), is("Carter"));
        assertThat(customer.getLastname(), is("Beauford"));
    }
}
