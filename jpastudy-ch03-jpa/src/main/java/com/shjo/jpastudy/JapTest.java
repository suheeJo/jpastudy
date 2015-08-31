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
        	Member member = new Member("id2", "shjo", 25);
        	entityManager.persist(member);

//          logic_cache(entityManager, member);
            
//          logic_dirtyChecking(entityManager);
        	
        	logic_merge(entityManager, member, entityTransaction);
        	
            entityTransaction.commit();
        } catch (Exception e) {
        	e.printStackTrace();
        	entityTransaction.rollback(); 
        } finally {
        	entityManager.close(); 
        }

        entityManagerFactory.close();
	}
	
	private static void logic_merge(EntityManager entityManager, Member member, EntityTransaction entityTransaction) {
		entityTransaction.commit();
		entityTransaction.begin();
		
		entityManager.detach(member);
		member.setAge(500); // 준영속 상태 확인: DB 값 변경 안됨
		
		Member member2 = member; // member2는 준영속 상태..? 일것 같음
		/*
		 * javax.persistence.PersistenceException: org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned before calling save() 에러.......
		 */
//		member2.setId(null); // @ID 값이 없으면 merge가 될까? -> 안됨 @generatedValue 는 됨
		Member mergeMember = entityManager.merge(member2); // mergeMemeber는 영속, merge2는 준영속?
		
		mergeMember.setAge(500); // 이게 바뀜
		member2.setAge(1000); // 이건 안바뀜
		
		mergeMember.setAge(1000); // 이게 바뀜
		System.out.println("동일성: " + (member2 == mergeMember)); // false
		System.out.println("동등성: " + (member2.equals(mergeMember))); // true
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
