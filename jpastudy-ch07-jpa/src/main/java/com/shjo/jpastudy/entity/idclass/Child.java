package com.shjo.jpastudy.entity.idclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class Child {
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "parent_id1",
					referencedColumnName = "parent_id1"),
		@JoinColumn(name = "parent_id2",
					referencedColumnName = "parent_id2")
	})
	private Parent parent;
}
