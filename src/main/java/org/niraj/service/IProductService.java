package org.niraj.service;

import java.util.List;

import org.niraj.entity.Product;

public interface IProductService {

	List<Product> getAllProducts();
	Product getProductById(int productId);
	String deleteProduct(int productId);
	Product addProduct(Product productVo);
	Product updateProduct(int productId, Product productVo);
	List<Product> getAllProductsSortedByComparator(String sortBy);
	List<Product> getProductsInRange(int start, int count);
	List<Product> getAllProductsSortedByQuery(String sortBy);	

}