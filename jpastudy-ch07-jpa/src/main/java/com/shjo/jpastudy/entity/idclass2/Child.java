package com.shjo.jpastudy.entity.idclass2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
//@Entity
@IdClass(ChildId.class)
public class Child {
	@Id
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Parent parent;
	
	@Id
	@Column(name = "child_id")
	private String childId;
	
	private String name;
}
