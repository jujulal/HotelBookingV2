package org.mum.hotel.service;



import java.util.List;

import org.mum.hotel.dao.CustomerDao;
import org.mum.hotel.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	protected CustomerDao customerDAO;
	
	public void addCustomer(Customer customer){
		customerDAO.addCustomer(customer);
	}
	
	public List<Customer> getAllCustomer(){
		return customerDAO.getAllCustomers();
	}

}
