package com.shjo.jpastudy.entity.idclass2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Parent {
	@Id
	@GeneratedValue
	@Column(name = "parent_id")
	private String id;
	
	private String name;
}
