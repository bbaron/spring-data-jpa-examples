package org.springframework.data.jpa.tutorial.core;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

public abstract class AbstractTutorialTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setupData() throws Exception {

        if (countRowsInTable("Customer") == 0) {
            executeSqlScript("classpath:data.sql", false);
        }
    }

}
