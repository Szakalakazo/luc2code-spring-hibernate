package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.openSession();

        currentSession.beginTransaction();

        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by lastName",
                        Customer.class);

        List<Customer> customers = theQuery.getResultList();

        currentSession.getTransaction().commit();
        currentSession.close();


        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session currentSession = sessionFactory.openSession();

        currentSession.beginTransaction();

        currentSession.saveOrUpdate(customer);

        currentSession.getTransaction().commit();
        currentSession.close();

    }

    @Override
    public Customer getCustomers(int theId) {

        Session currentSession = sessionFactory.openSession();

        Customer customer = currentSession.get(Customer.class, theId);

        currentSession.beginTransaction();

        currentSession.getTransaction().commit();
        currentSession.close();

        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {

        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();

        Query query =
                currentSession.createQuery("DELETE from Customer where id=:customerId");

        query.setParameter("customerId", theId).executeUpdate();

        currentSession.getTransaction().commit();
        currentSession.close();
    }
}