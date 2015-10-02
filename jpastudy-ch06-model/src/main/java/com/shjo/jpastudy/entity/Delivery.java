package com.shjo.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Delivery {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="delivery_id")
	private Long id;
	
	@OneToOne(mappedBy="delivery")
	private Orders orders;
	
	private String city;
	private String street;
	private String zipCode;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
}
