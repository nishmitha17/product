package com.te.productweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.productweb.beans.ProductInfoBean;

@Repository
public class ProductHibernateImpl implements ProductDao{

	@Override
	public ProductInfoBean authenticate(int id, String accesstype) {
		
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		try {
			factory=Persistence.createEntityManagerFactory("emsPeristenceUnit");
		    manager=factory.createEntityManager();
		    ProductInfoBean product=manager.find(ProductInfoBean.class, id);
		    System.out.println(product.getId());
		    if(product!=null) {
		    	if(product.getAccessType().equalsIgnoreCase(accesstype)) {
		    		return product;
		    	}else {
		    		return null;
		    	}
		    }else {
		    	return null;
		    }
	} 
		    catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		}
				
		return null;
	}

}
