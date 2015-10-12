package com.shjo.jpastudy.entity.embeddedid;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@Embeddable
public class ParentId implements Serializable{
	@Column(name = "parent_id1")
	private String id1;
	
	@Column(name = "parent_id2")
	private String id2;
}
