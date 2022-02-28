package org.niraj.service;

import java.util.Collections;
import java.util.List;

import org.niraj.controller.ProductController;
import org.niraj.dao.IProductDAO;
import org.niraj.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

//	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private IProductDAO productDao;

	
	@Override
	public List<Product> getAllProducts(){
//		logger.info("GetAllProducts method called in ProductService ");
		return productDao.getAllProducts()  ;
	}
	
	@Override
	public Product getProductById(int productId){
//		logger.info("GetProduct method called in ProductService ==> "+productId);
		return productDao.getProductById(productId);
	}
	
	@Override
	public String deleteProduct(int productId){
//		logger.info("Delete method in Product Service called for ProductId ==> " + productId);
		return productDao.deleteProduct(productId);
	}

	@Override
	public Product addProduct(Product productVo){
//		logger.info("addProduct method in ProductService ==> "+productVo);
		return productDao.addProduct(productVo);
	}
	
	@Override
	public Product updateProduct(int productId , Product productVo){
//		logger.info("updateProduct method in ProductService ==> "+productId+"==>"+productVo);
		return productDao.updateProduct(productId, productVo);
	}


	/* This method will return product list based on the sorting parameter
	 * for price sorting price and for name sorting, name will be in the request path
	 * If no match then show the default order.
	 * */
	@Override
	public List<Product> getAllProductsSortedByComparator(String sortBy) {
		List<Product> prodList = productDao.getAllProducts();

		switch(sortBy){
			case "price":
				ProductComparatorPrice prodPriceComp = new ProductComparatorPrice();
				Collections.sort(prodList, prodPriceComp); 
				break;
			case "name":
				ProductComparatorName prodNameComp = new ProductComparatorName();
				Collections.sort(prodList, prodNameComp); 
				break;
		}		
		return prodList;
	}
	
	@Override
	public List<Product> getProductsInRange(int start , int count){
		List<Product> prodList = productDao.getProductsByRange(start, count);
		return prodList;
	}

	@Override
	public List<Product> getAllProductsSortedByQuery(String sortBy) {
		List<Product> prodList = productDao.getAllProductsByQuerySorting(sortBy);
		return prodList;
	}
			
}
