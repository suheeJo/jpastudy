package com.shjo.jpastudy.entity.singletable;

import javax.persistence.DiscriminatorValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
@DiscriminatorValue("A")
public class Album2 extends Item2{
	private String artist;
}
