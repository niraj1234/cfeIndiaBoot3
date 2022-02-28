package org.niraj.service;

import java.util.Comparator;

import org.niraj.entity.Product;

public class ProductComparatorPrice implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		int result;
			if (p1.getPrice() > p2.getPrice()) {result = 1;} 
			else if (p1.getPrice() < p2.getPrice()) {result = -1;} 
			else {result = 0;}
		return result;
	}

}
