package com.shjo.jpastudy.entity.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item3 {
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Long id;
	
	private String name;
	private int price;
}

