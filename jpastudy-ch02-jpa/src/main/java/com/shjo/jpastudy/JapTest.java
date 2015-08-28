package com.shjo.jpastudy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JapTest {

	public static void main(String[] args) {
		// 엔티티 매니저 팩토리 - 생성
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");
        
        // 엔티티 매니저 - 생성
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // 트랜잭션 기능 - 생성
        EntityTransaction entityTransaction = entityManager.getTransaction(); 

        try {
        	// 트랜잭션 - 시작
        	entityTransaction.begin(); 
        	
        	// 비즈니스 로직
        	String id = "id1";
            Member member = new Member();
            member.setId(id);
            member.setUsername("shjo");
            member.setAge(25);

            // 등록
            entityManager.persist(member);

            // 수정
            member.setAge(20);

            // 한 건 조회
            Member getMember = entityManager.find(Member.class, id);
            System.out.println("###### getMember: " + getMember);

            // 목록 조회
            List<Member> memberList = entityManager.createQuery("SELECT m FROM Member m", Member.class).getResultList();
            System.out.println("###### memberList.size=" + memberList.size());

            // 삭제
            entityManager.remove(member);
            
            // 트랜잭션 - 커밋
            entityTransaction.commit();
        } catch (Exception e) {
        	// 트랜잭션 - 롤백
        	entityTransaction.rollback(); 
        } finally {
        	// 엔티티 매니저 - 종료
        	entityManager.close(); 
        }

        // 엔티티 매니저 팩토리 - 종료
        entityManagerFactory.close();
	}
}
