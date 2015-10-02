package com.shjo.jpastudy.entity.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("A")
public class Album extends Item{
	private String artist;
}
