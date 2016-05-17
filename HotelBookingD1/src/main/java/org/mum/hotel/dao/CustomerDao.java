package org.mum.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.mum.hotel.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);

	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		 List<Customer> resultList = entityManager.createQuery("select * from Customer", Customer.class).getResultList();
		return resultList;
	}
	
	public Customer getCustomer(int custNo){
		return entityManager.find(Customer.class, custNo);
	}
}
