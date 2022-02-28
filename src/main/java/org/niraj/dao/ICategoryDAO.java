package org.niraj.dao;

import java.util.List;

import org.niraj.entity.Category;

public interface ICategoryDAO {

	List<Category> getAllCategories();

	Category getCategoryById();

}