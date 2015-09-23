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
@Table(name="MEMBER")
public class MemberEntity {
	@Id
	@GeneratedValue
	@Column(name="member_id")
	private Long id;
	
	private String userName;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private TeamEntity teamEntity;
}
