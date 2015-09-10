package com.shjo.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ORDER_ITEM")
public class OrderItemEntity {
	@Id
	@GeneratedValue
	@Column(name="ORDER_ITEM_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private OrderEntity orderEntity;
	
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private ItemEntity itemEntity;
	
	@Column(name="ORDER_PRICE")
	private int orderPrice;
	private int count;
	
	// 왜 이건 안함????
	public void setOrderEntity(OrderEntity orderEntity) {
		if(this.orderEntity != null) {
			this.orderEntity.getOrderItemEntityList().remove(this);
		}
		this.orderEntity = orderEntity;
		orderEntity.getOrderItemEntityList().add(this);
	}
}
