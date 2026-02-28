package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao cstDao;
	
	@Override
	public Customer saveCustomer(Customer cst) {
		return cstDao.saveCustomer(cst);
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		return cstDao.getCustomerById(id);
	}

	@Override
	public Customer updateCustomer(Customer cst) {
		return cstDao.updateCustomer(cst);
	}

	@Override
	public List<Customer> deleteCustomerByID(int id) {
		return cstDao.deleteCustomerByID(id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return cstDao.getAllCustomer();
	}

	
}
