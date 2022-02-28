package org.niraj.service;

import java.util.List;

import org.niraj.dao.ICategoryDAO;
import org.niraj.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDAO categoryDao;

	@Override
	public List<Category> getAllCategory() {
		return categoryDao.getAllCategories();
	}

}
