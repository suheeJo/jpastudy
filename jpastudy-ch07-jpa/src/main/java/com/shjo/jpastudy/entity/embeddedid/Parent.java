package com.shjo.jpastudy.entity.embeddedid;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Entity
public class Parent {
	@EmbeddedId
	private ParentId id;
	
	private String name;
}
