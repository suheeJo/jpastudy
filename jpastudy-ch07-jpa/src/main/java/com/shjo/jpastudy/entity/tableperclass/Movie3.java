package com.shjo.jpastudy.entity.tableperclass;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie3 extends Item3{
	private String disrector;
	private String actor;
}
