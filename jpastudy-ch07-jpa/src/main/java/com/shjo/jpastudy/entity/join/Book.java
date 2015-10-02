package com.shjo.jpastudy.entity.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "book_id")
public class Book extends Item{
	private String author;
	private String isbn;
}
