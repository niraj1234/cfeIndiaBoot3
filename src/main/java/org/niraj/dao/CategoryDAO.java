package org.niraj.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.niraj.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CategoryDAO implements ICategoryDAO {

	private SessionFactory hibernateFactory;
	
	@Autowired
	public CategoryDAO(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("|||| Oops, Exception Hibernate Session Factory ========>");
		}
		this.hibernateFactory = factory.unwrap(SessionFactory.class);
		System.out.println("Hibernate Session Factory Created successfully ===> CategoryDAO");
	}	

	
	@Override
	public List<Category> getAllCategories() {
		ArrayList<Category> categoryList = new ArrayList<Category>();
		String hql   = "FROM Category";
		Session sess = hibernateFactory.openSession();
		Transaction txn = sess.beginTransaction();
		Query query = sess.createQuery(hql);

		categoryList = (ArrayList<Category>) query.list();

		sess.getTransaction().commit();
		sess.close();
		return categoryList;
	}

	
	@Override
	public Category getCategoryById(){
		return null;
	}

}

