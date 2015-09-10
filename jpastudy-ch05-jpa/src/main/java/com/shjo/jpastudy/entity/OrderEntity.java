package com.shjo.jpastudy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="ORDERS")
public class OrderEntity {
	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private MemberEntity memberEntity;
	
	@OneToMany(mappedBy="orderEntity")
	private List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	public void setMemberEntity(MemberEntity memberEntity) {
		// 기존 관계 제거
		if(this.memberEntity != null) {
			this.memberEntity.getOrderList().remove(this);
		}
		this.memberEntity = memberEntity;
		memberEntity.getOrderList().add(this);
	}
	
	public void addOrderItem(OrderItemEntity orderItemEntity) {
		orderItemEntityList.add(orderItemEntity);
		orderItemEntity.setOrderEntity(this);
	}
}
