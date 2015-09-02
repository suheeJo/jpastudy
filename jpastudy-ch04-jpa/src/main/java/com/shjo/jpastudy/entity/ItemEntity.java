package com.shjo.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ITEM")
public class ItemEntity {
	@Id
	@GeneratedValue
	@Column(name="ITEM_ID")
	private Long id;
	private String name;
	private int price;
	@Column(name="STOCK_QUANTITY")
	private int stockQuantity;
}
