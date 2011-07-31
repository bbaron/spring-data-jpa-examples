package org.springframework.data.jpa.tutorial.after;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.tutorial.core.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
