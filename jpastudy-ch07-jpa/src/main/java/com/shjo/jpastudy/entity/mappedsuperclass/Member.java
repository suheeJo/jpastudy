package com.shjo.jpastudy.entity.mappedsuperclass;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member extends BaseEntity{
	private String email;
}
