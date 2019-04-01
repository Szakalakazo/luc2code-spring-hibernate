package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
//    @Transactional
    public List<Customer> getCustomers() {

        return customerDAO.getCustomers();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    public Customer getCustomers(int theId) {
        return customerDAO.getCustomers(theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }


}
