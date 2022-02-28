package org.niraj.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

//	This is working for JoinTable
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="PRODUCT_ID")
//	private int pkIdProduct;
	


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pkIdProduct")
	private int pkIdProduct;

	@Column(name="productName")
	private String productName;
	
	@Column(name="productDesc")
    private String productDescription;

	@Column(name="price")
    private int price ;
	

	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="categoryId" )
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	
	
    
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product() {
		super();
	}

	public Product(String productName, String productDescription, int price) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
	}
	
	public Product(int pkIdProduct, String productName, String productDescription, int price) {
		super();
		this.pkIdProduct = pkIdProduct;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
	}


	public int getPkIdProduct() {
		return pkIdProduct;
	}
	public void setPkIdProduct(int pkIdProduct) {
		this.pkIdProduct = pkIdProduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [pkIdProduct=" + pkIdProduct + ", productName=" + productName + ", productDescription="
				+ productDescription + ", price=" + price + "]";
	}
	
}
