package org.niraj.dao;

import java.util.List;

import org.niraj.entity.Product;


public interface IProductDAO {

	List<Product> getAllProducts();

	Product getProductById(int productId);

	String deleteProduct(int productId);

	Product addProduct(Product productVo);

	Product updateProduct(int productId, Product productVo);

	List<Product> getProductsByRange(int start, int count);

	List<Product> getAllProductsByQuerySorting(String sortBy);

}