package org.springframework.data.jpa.tutorial.after;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.tutorial.core.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    /**
     * Returns a page of {@link Customer}s with the given lastname.
     * 
     * @param lastname
     * @param pageable
     * @return
     */
    Page<Customer> findByLastname(String lastname, Pageable pageable);

}
