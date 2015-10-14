package com.shjo.jpastudy.entity.idclass2;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode
public class ChildId implements Serializable {
	private String parent;
	private String childId;
}
