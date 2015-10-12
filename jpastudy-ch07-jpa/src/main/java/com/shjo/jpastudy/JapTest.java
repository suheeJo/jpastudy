package com.shjo.jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shjo.jpastudy.entity.embeddedid.Parent;
import com.shjo.jpastudy.entity.embeddedid.ParentId;

public class JapTest {

	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
        	transaction.begin();
        	
        	Parent parent = new Parent();
        	ParentId parentId = new ParentId("myId1", "myId2");
        	parent.setId(parentId);
        	parent.setName("parentName");
        	manager.persist(parent);
        	
        	ParentId parentIdParam = new ParentId("myId1", "myId2");
        	Parent getParent = manager.find(Parent.class, parentIdParam);
        	System.out.println("find: " + getParent);
        	
        	transaction.commit();
        }catch(Exception e) {
        	transaction.rollback();
        }finally {
        	manager.close();
        }
        factory.close();
	}
}
