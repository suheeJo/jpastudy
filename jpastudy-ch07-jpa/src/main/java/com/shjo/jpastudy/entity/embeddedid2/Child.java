package com.shjo.jpastudy.entity.embeddedid2;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Child {
	@EmbeddedId
	private ChildId child;
	
	@MapsId("parentId")
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Parent parent;
	
	private String name;
}
