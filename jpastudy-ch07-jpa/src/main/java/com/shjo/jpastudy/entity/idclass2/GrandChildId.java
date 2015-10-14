package com.shjo.jpastudy.entity.idclass2;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode
public class GrandChildId implements Serializable {
	private ChildId child;
	private String id;
}
