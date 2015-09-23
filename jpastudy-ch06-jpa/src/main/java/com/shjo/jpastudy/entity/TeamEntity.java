package com.shjo.jpastudy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="teamEntity")
	private List<MemberEntity> memberList = new ArrayList<>();
	
	public void addMember(MemberEntity memberEntity) {
		this.memberList.add(memberEntity);
		if(memberEntity.getTeamEntity() != this) {
			memberEntity.setTeam(this);
		}
	}
}
