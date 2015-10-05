package com.shjo.jpastudy.entity.singletable;

import javax.persistence.DiscriminatorValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
@DiscriminatorValue("B")
public class Book2 extends Item2{
	private String author;
	private String isbn;
}
