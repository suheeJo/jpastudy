package com.shjo.jpastudy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name = "category_item"
			, joinColumns = @JoinColumn(name="category_id")
			, inverseJoinColumns = @JoinColumn(name="item_id"))
	private List<Item> itemList = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Category parent;
	
	@OneToMany(mappedBy="parent")
	private List<Category> childList = new ArrayList<>();
	
	public void addChildCategory(Category child) {
		childList.add(child);
		child.setParent(this);
	}
	
	public void addItem(Item item) {
		itemList.add(item);
	}
}
