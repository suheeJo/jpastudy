package com.shjo.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Order_Item")
public class OrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_item_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Orders orders;
	
	private int orderPrice;
	private int count;
}
