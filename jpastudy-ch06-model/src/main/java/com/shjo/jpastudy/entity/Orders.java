package com.shjo.jpastudy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orders_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	@OneToMany(mappedBy="orders")
	private List<OrderItem> orderItemList = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="delivery_id")
	private Delivery delivery;
	
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	public void setMember(Member member) {
		if(this.member != member) {
			this.member.getOrdersList().remove(this);
		}
		this.member = member;
		member.getOrdersList().add(this);
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItemList.add(orderItem);
		orderItem.setOrders(this);
	}
	
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
		delivery.setOrders(this);
	}
}
