package com.shjo.jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JapTest {

	public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction(); 

        try {
        	entityTransaction.begin(); 
            Member member = entityManager.find(Member.class, "id2");

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
            
            
            entityTransaction.commit();
        } catch (Exception e) {
        	entityTransaction.rollback(); 
        } finally {
        	entityManager.close(); 
        }

        entityManagerFactory.close();
	}
}
