package com.shjo.jpastudy.entity.embeddedid2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Parent {
	@Id
	@Column(name = "parent_id")
	private String id;
	
	private String name;
}
