package com.shjo.jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shjo.jpastudy.entity.idclass.Parent;

public class JapTest {

	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
        	transaction.begin();
        	
        	Parent parent = new Parent();
        	parent.setId1("myId1");
        	parent.setId2("myId2");
        	parent.setName("parentName");
        	
        	manager.persist(parent);
        	
        	transaction.commit();
        }catch(Exception e) {
        	transaction.rollback();
        }finally {
        	manager.close();
        }
        factory.close();
	}
}
