package com.shjo.jpastudy.entity.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("M")
public class Movie extends Item{
	private String disrector;
	private String actor;
}
