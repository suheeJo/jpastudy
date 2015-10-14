package com.shjo.jpastudy.entity.idclass2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
@IdClass(GrandChildId.class)
public class GrandChild {
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "parent_id"), // TODO ERROR : Referenced column name must be specified when there are multiple join columns 
		@JoinColumn(name = "child_id")
	})
	private Child child;
	
	@Id
	@Column(name = "grandchild_id")
	private String id;
	private String name;
}
