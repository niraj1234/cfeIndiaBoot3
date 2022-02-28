package org.niraj.controller;

import java.util.List;

import org.niraj.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;


public interface IProductController {

	ResponseEntity<Product> getProductById(Integer id);

	ResponseEntity<List<Product>> getAllProducts();

	ResponseEntity<Void> addProduct(Product prodVo, UriComponentsBuilder uriBuilder);

	ResponseEntity<Product> updateProduct(Product prodVo, Integer pid);

	ResponseEntity<String> deleteProduct(Integer id);

	ResponseEntity<List<Product>> getAllProductsSorted(String sortBy);

	ResponseEntity<List<Product>> getAllProductsSortedByQuery(String sortBy);

	ResponseEntity<List<Product>> getProductsInRange(int start, int count);

}