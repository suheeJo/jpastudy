package com.shjo.jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shjo.jpastudy.entity.MemberEntity;
import com.shjo.jpastudy.entity.TeamEntity;

public class JapTest {

	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
        	transaction.begin();
        	
        	MemberEntity member1 = new MemberEntity("member1");
        	MemberEntity member2 = new MemberEntity("member2");
        	
        	TeamEntity team1 = new TeamEntity("team1");
        	team1.getMemberList().add(member1);
        	team1.getMemberList().add(member2);
        	
        	manager.persist(member1);
        	manager.persist(member2);
        	manager.persist(team1);
        	
        	transaction.commit();
        }catch(Exception e) {
        	transaction.rollback();
        }finally {
        	manager.close();
        }
        factory.close();
	}
}
