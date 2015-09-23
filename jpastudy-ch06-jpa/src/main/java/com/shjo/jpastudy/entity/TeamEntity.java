package com.shjo.jpastudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TEAM")
public class TeamEntity {
	@Id
	@GeneratedValue
	@Column(name="team_id")
	private Long id;
	
	private String name;
}
