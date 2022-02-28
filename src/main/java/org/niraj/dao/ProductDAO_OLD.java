package org.niraj.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.niraj.controller.ProductController;
import org.niraj.entity.Product;
import org.niraj.service.ProductComparatorName;
import org.niraj.service.ProductComparatorPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Hibernate Implementation for Product related DB call THis Repository is used
 * for SpringREST application
 */



/*

@Repository
public class ProductDAO_OLD implements IProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAO_OLD.class);

	private SessionFactory hibernateFactory;

	@Autowired
	public ProductDAO_OLD(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException(
					"Oooooopppssss, Exception in creating Hibernate Session Factory ============>");
		}
		this.hibernateFactory = factory.unwrap(SessionFactory.class);
		logger.info("Hibernate Session Factory Created successfully ===> ProductDAO");
	}

	
	
	@Override
	public List<Product> getAllProducts() {
		ArrayList<Product> productList = new ArrayList<Product>();
		String hql = "from Product";
		Session sess = hibernateFactory.openSession();
		Transaction txn = sess.beginTransaction();
		Query query = sess.createQuery(hql);

		productList = (ArrayList<Product>) query.list();

		sess.getTransaction().commit();
		sess.close();
		return productList;
	}

	

	
	@Override
	public List<Product> getProductsByRange(int start , int count) {
		ArrayList<Product> productList = new ArrayList<Product>();
		String hql = "from Product";
		Session sess = hibernateFactory.openSession();
		Transaction txn = sess.beginTransaction();
		Query query = sess.createQuery(hql);

		query.setFirstResult(start);
		query.setMaxResults(count);

		productList = (ArrayList<Product>) query.list();

		sess.getTransaction().commit();
		sess.close();
		return productList;
	}

	
	

	
	@Override
	public Product getProductById(int productId) {
		Session sess = hibernateFactory.openSession();
		Transaction txn = sess.beginTransaction();

		Product prodVo = (Product) sess.get(Product.class, productId);

		sess.getTransaction().commit();
		sess.close();
		return prodVo;
	}

	
	
	@Override
	public String deleteProduct(int productId) {
		Session sess = hibernateFactory.openSession();
		Transaction txn = sess.beginTransaction();

		Product prodVo = (Product) sess.get(Product.class, productId);
		if (null != prodVo) {
			sess.delete(prodVo);
			logger.info("Product Deleted Sucecssfully" + prodVo);
		}

		sess.getTransaction().commit();
		sess.close();
		return "productDeleted" + productId;
	}

	
	
	@Override
	public Product addProduct(Product productVo) {
		Session sess = hibernateFactory.openSession();
		Transaction txn = sess.beginTransaction();
		sess.save(productVo);
		sess.getTransaction().commit();
		sess.close();

		sess = hibernateFactory.openSession();
		txn = sess.beginTransaction();
		Product p1 = (Product) sess.get(Product.class, productVo.getPkIdProduct());
		sess.getTransaction().commit();
		sess.close();

		return p1;
	}

	
	
	@Override
	public Product updateProduct(int productId, Product productVo) {

		String hql = "update Product set productName = :prodName , productDescription = :prodDesc , price = :price where pkIdProduct = :pid ";

		Session sess = hibernateFactory.openSession();
		Transaction txn = sess.beginTransaction();
		Query query = sess.createQuery(hql);
		query.setParameter("prodName", productVo.getProductName());
		query.setParameter("prodDesc", productVo.getProductDescription());
		query.setParameter("price", productVo.getPrice());
		query.setParameter("pid", productId);

		int rowUpdated = query.executeUpdate();

		sess.getTransaction().commit();
		sess.close();
		logger.info("Update row count for Product is  ===>  " + rowUpdated);
		System.out.println();
		productVo.setPkIdProduct(productId);
		return productVo;
	}



	@Override
	public List<Product> getAllProductsByQuerySorting(String sortBy) {
		ArrayList<Product> productList = new ArrayList<Product>();
		String hql = "from Product";
		
		switch (sortBy) {
		case "price":
			hql = hql + " order by price asc";
			break;
		case "name":
			hql = hql + " order by productName asc";
			break;
		}

		Session sess = hibernateFactory.openSession();
		Transaction txn = sess.beginTransaction();
		Query query = sess.createQuery(hql);

		productList = (ArrayList<Product>) query.list();

		sess.getTransaction().commit();
		sess.close();
		return productList;
	}

	
}

*/