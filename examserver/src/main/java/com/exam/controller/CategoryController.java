package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController
{
	@Autowired
	private CategoriesService categoriesService;

	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		Category category1 = this.categoriesService.addCategory(category);
		return ResponseEntity.ok(category1);
	}

	@GetMapping("/{id}")
	public Category getCategory(@PathVariable("id") Long id){
		return categoriesService.getCategory(id);
	}

	@GetMapping("/getAll")
	public Set<Category> getAllCategory(Category category){
		return categoriesService.getCategory();
	}

	@PutMapping("/")
	public Category update(@RequestBody Category category){
		return categoriesService.updateCategory(category);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		categoriesService.delete(id);
	}
}
