package org.niraj.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.niraj.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Hibernate Implementation for Product related DB call

@Repository
@Transactional(rollbackFor = Exception.class)
public class ProductDAO implements IProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);

	private SessionFactory hibernateFactory;

	@Autowired
	public ProductDAO(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("|||| Oops, Exception Hibernate Session Factory ==>");
		}
		this.hibernateFactory = factory.unwrap(SessionFactory.class);
//		logger.info("Hibernate Session Factory Created successfully ===> ProductDAO");
		System.out.println("Hibernate Session Factory Created successfully ===> ProductDAO");
	}

	@Override
	public List<Product> getAllProducts() {
		ArrayList<Product> productList = new ArrayList<Product>();
		String hql = "from Product";
		Session sess = hibernateFactory.openSession();
		Query query = sess.createQuery(hql);
		productList = (ArrayList<Product>) query.list();
		sess.close();
		return productList;
	}

	@Override
	public List<Product> getProductsByRange(int start, int count) {
		ArrayList<Product> productList = new ArrayList<Product>();
		String hql = "from Product";
		Session sess = hibernateFactory.openSession();
		Query query = sess.createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(count);
		productList = (ArrayList<Product>) query.list();
		sess.close();
		return productList;
	}

	@Override
	public Product getProductById(int productId) {
		Session sess = hibernateFactory.openSession();
		Product prodVo = (Product) sess.get(Product.class, Integer.valueOf(productId));
		sess.close();
		return prodVo;
	}

	/* Using programmatic transaction as declarative is not working */
	@Override
	public String deleteProduct(int productId) {
		Session sess = hibernateFactory.openSession();
		Transaction txn = sess.beginTransaction();

		Product prodVo = (Product) sess.get(Product.class, productId);
		if (null != prodVo) {
			sess.delete(prodVo);
//			logger.info("Product Deleted Sucecssfully" + prodVo);
			System.out.println("Product Deleted Sucecssfully" + prodVo);
		}

		sess.getTransaction().commit();
		sess.close();
		return "productDeleted" + productId;
	}

	@Override
	public Product addProduct(Product productVo) {
		Session sess = hibernateFactory.openSession();
		sess.save(productVo);
		
//		  try { Thread.sleep(5000); } catch (InterruptedException e) {
//		  e.printStackTrace(); }		  
//		  if(productVo.getPrice() > 10000){ throw new RuntimeException(); }
		 
		Product p1 = (Product) sess.get(Product.class, productVo.getPkIdProduct());
		sess.close();
		return p1;
	}

	@Override
	public Product updateProduct(int productId, Product productVo) {

		String hql = "update Product set productName = :prodName , productDescription = :prodDesc , "
				+ "price = :price " + "where pkIdProduct = :pid ";

		Session sess = hibernateFactory.openSession();

		Query query = sess.createQuery(hql);
		query.setParameter("prodName", productVo.getProductName());
		query.setParameter("prodDesc", productVo.getProductDescription());
		query.setParameter("price", productVo.getPrice());
		query.setParameter("pid", productId);

		int rowUpdated = query.executeUpdate();

		sess.close();
//		logger.info("Update row count for Product is  ===>  " + rowUpdated);
		System.out.println("Update row count for Product is  ===>  " + rowUpdated);
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
		Query query = sess.createQuery(hql);
		productList = (ArrayList<Product>) query.list();
		sess.close();
		return productList;
	}

} // END ProductDAO
