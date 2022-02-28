package org.niraj.controller;

import java.util.List;

import org.niraj.entity.Category;
import org.springframework.http.ResponseEntity;

public interface ICategoryController {

	ResponseEntity<List<Category>> getAllCategory();

}