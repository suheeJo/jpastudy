package com.shjo.jpastudy.entity.embeddedid2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Embeddable
@EqualsAndHashCode
public class GrandChildId implements Serializable {
	private ChildId childId;
	
	@Column(name = "grandchild_id")
	private String id;
}
