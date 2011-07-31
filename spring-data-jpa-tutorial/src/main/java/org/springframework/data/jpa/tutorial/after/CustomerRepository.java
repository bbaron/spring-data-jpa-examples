package org.springframework.data.jpa.tutorial.after;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.tutorial.core.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
