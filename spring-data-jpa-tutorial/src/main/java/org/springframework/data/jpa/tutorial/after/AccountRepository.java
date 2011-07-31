package org.springframework.data.jpa.tutorial.after;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.tutorial.core.Account;
import org.springframework.data.jpa.tutorial.core.Customer;

public interface AccountRepository extends JpaRepository<Account, Long> {
    /**
     * Returns all {@link Account}s of the given {@link Customer}.
     * 
     * @param customer
     * @return
     */
    List<Account> findByCustomer(Customer customer);

}
