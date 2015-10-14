package com.shjo.jpastudy.entity.embeddedid2;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GrandChild {
	@EmbeddedId
	private GrandChildId id;
	
	@MapsId("childId")
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "parent_id"),
		@JoinColumn(name = "child_id")
	})
	private Child child;
	
	private String name;

}
