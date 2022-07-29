package com.example.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productcategory")
public class ProductCategory {
	
	@Id		// primary key
	@Column(name="categoryid")
	private Integer categoryId;
	
	@Column(name="categoryname")
	private String name;
	
	public ProductCategory() {
		// TODO Auto-generated constructor stub
	}

	public ProductCategory(Integer categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.name = categoryName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return name;
	}

	public void setCategoryName(String categoryName) {
		this.name = categoryName;
	}

	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + name + "]";
	}
	
}
