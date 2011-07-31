package org.springframework.data.jpa.tutorial.after;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.tutorial.before.CustomerService;
import org.springframework.data.jpa.tutorial.core.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Plain JPA implementation of {@link CustomerService}.
 * 
 * @author Oliver Gierke
 */
@Repository
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private CustomerRepository repo;

    @Override
    public Customer findById(Long id) {
        return repo.findOne(id);
    }

    @Override
    public Iterable<Customer> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Customer> findAll(int page, int pageSize) {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);

        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public List<Customer> findByLastname(String lastname, int page, int pageSize) {

        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.lastname = ?1", Customer.class);

        query.setParameter(1, lastname);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }
}
