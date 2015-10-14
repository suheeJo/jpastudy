package com.shjo.jpastudy.entity.embeddedid2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;

@Embeddable
@SuppressWarnings("serial")
@EqualsAndHashCode
public class ChildId implements Serializable {
	private String parentId;
	
	@Column(name = "child_id")
	private String id;
}
