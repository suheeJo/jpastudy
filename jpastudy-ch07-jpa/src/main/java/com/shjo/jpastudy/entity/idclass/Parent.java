package com.shjo.jpastudy.entity.idclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
@IdClass(ParentId.class)
public class Parent {
	@Id
	@Column(name="parent_id1")
	private String id1;
	
	@Id
	@Column(name="parent_id2")
	private String id2;
	
	private String name;
}
