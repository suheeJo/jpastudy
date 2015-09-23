package com.shjo.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="MEMBER")
public class MemberEntity {
	@Id
	@GeneratedValue
	@Column(name="member_id")
	private Long id;
	
	private String userName;
	
	public MemberEntity(String userName) {
		this.userName = userName;
	}
}
