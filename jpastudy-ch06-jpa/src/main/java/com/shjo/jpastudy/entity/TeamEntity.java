package com.shjo.jpastudy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@NoArgsConstructor
//@Table(name="TEAM")
public class TeamEntity {
	@Id
	@GeneratedValue
	@Column(name="team_id")
	private Long id;
	
	private String name;
	
	@OneToMany
	@JoinColumn(name="team_id")
	private List<MemberEntity> memberList = new ArrayList<>();
	
	public TeamEntity(String name) {
		this.name = name;
	}
}
