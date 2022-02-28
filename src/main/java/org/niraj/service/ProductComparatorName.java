package org.niraj.service;

import java.util.Comparator;

import org.niraj.entity.Product;

public class ProductComparatorName implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p1.getProductName().compareTo(p2.getProductName());
	}

}
