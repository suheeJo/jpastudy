package com.shjo.jpastudy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="MEMBER")
public class MemberEntity {
	@Id
	@GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	
	private String name;
	private String city;
	private String street;
	private String zipcode;
	
	@OneToMany(mappedBy="memberEntity")
	private List<OrderEntity> orderList = new ArrayList<>();
}
