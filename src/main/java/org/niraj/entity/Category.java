package org.niraj.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Category")
@Proxy(lazy = false)
public class Category {

	@Id @GeneratedValue
	@Column(name="categoryId")
	private int categoryId;

	@Column(name="categoryName")
	private String categoryName;
	
/*	This is working for JoinTable 
	@OneToMany( cascade= CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinTable( name = "CATEGORY_PRODUCT", 
	            joinColumns = @JoinColumn(name = "CATEGORY_ID"), 
	            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	Set<Product> products;
*/	
	
	
	// use [@JsonIgnore] other wise Failed to write HTTP message: 
	// org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON:
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	@JsonIgnore 
	Set<Product> products;
	
	public Category() {
		super();
	}	
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
		
}
