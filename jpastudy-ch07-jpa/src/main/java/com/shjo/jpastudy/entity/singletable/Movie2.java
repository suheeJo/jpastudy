package com.shjo.jpastudy.entity.singletable;

import javax.persistence.DiscriminatorValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
@DiscriminatorValue("M")
public class Movie2 extends Item2{
	private String disrector;
	private String actor;
}
