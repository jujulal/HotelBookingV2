package org.mum.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mum.hotel.domain.Billing;
import org.springframework.stereotype.Repository;

@Repository
public class BillingDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addBill(Billing bill){
		entityManager.persist(bill);
	}
	public List<Billing> getAllBill(){
		return entityManager.createQuery("select * from Billing", Billing.class).getResultList();
	}
	public Billing getByBillingNo(Integer billingNo){
		return entityManager.find(Billing.class, billingNo);
	}
public void updateCheckIn(Billing billing){
	
		
		entityManager.merge(billing);
	}

}
