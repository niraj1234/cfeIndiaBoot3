package org.niraj.controller;

import java.util.List;

import org.niraj.entity.Category;
import org.niraj.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/category")
public class CategoryController implements ICategoryController {

	@Autowired
	private ICategoryService categoryService;


	@Override
	@GetMapping(value = "/all")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> categoryList = categoryService.getAllCategory();
		return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
	}

}
