package com.shjo.jpastudy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JapTest {

	public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction(); 

        try {
        	entityTransaction.begin(); 
            Member member = entityManager.find(Member.class, "id2");
            
//            logic_cache(entityManager, member);
            
            logic_dirtyChecking(entityManager);
            
            
            entityTransaction.commit();
        } catch (Exception e) {
        	e.printStackTrace();
        	entityTransaction.rollback(); 
        } finally {
        	entityManager.close(); 
        }

        entityManagerFactory.close();
	}
	
	private static void logic_dirtyChecking(EntityManager entityManager) {
		for (int i = 0; i < 20; i++) {
			entityManager.persist(new Member("id" + i, "username" + i, i));
		}
		
		/*
		 * JPA select & update
		 * 20번 실행
		 */
        List<Member> memberList = entityManager.createQuery("SELECT m FROM Member m", Member.class).getResultList();
		for (Member member : memberList) {
			member.setAge(100);
		}
		System.out.println("=================================================");
		
		
		/*
		 * JPQL update
		 * 1번 실행
		 */
		Query query = entityManager.createQuery("UPDATE Member SET age = 100");
		int updateCount = query.executeUpdate();
		System.out.println("###### updateCount: " + updateCount);
	}
	
	private static void logic_cache(EntityManager entityManager, Member member) {
        /*
         * DB 에서 id2의 값을 id3으로 바꿈(id3 값을 반환, 수정, 삭제)
         * -> 에러 발생
            INFO: HHH000010: On release of batch it still contained JDBC statements
            Exception in thread "main" java.lang.IllegalStateException: Transaction not active
            	at org.hibernate.jpa.internal.TransactionImpl.rollback(TransactionImpl.java:97)
            	at com.shjo.jpastudy.JapTest.main(JapTest.java:36)
    	*/
        System.out.println("get member: " + member);
        
        member.setAge(100);
        System.out.println("update member: " + member);
        
        entityManager.remove(member);
        System.out.println("delete smember2: " + member);
        
        /*
         * DB에서 다시 id 값을 기존 DB에 있는 id 값으로 바꿈(id2 값을 반환, 수정, 삭제)
         * -> 실행 잘됨
         */
        System.out.println("get member: " + member);
        
        member.setAge(200);
        System.out.println("update member: " + member);
        
        entityManager.remove(member);
        System.out.println("delete smember2: " + member);
	}
}
