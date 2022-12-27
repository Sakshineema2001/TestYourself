package com.exam.services;

import com.exam.model.exam.Category;

import java.util.Set;

public interface CategoriesService
{
	public Category addCategory(Category category);

	public Category updateCategory(Category category);

	public Set<Category> getCategory();

	public Category getCategory(Long id);

	public void delete(Long id);
}
