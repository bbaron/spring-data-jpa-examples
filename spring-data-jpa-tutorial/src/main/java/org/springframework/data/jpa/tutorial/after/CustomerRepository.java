package org.springframework.data.jpa.tutorial.after;

import org.springframework.data.jpa.tutorial.core.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
