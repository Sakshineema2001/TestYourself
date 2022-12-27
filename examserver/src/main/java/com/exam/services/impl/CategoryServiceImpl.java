package com.exam.services.impl;

import com.exam.model.exam.Category;
import com.exam.repository.CategoryRepository;
import com.exam.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoriesService
{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category)
	{
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category)
	{
		return categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategory()
	{
		return new HashSet<>(categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long id)
	{
		return categoryRepository.findById(id).get();
	}

	@Override
	public void delete(Long id)
	{
		Category category = new Category();
		category.setCid(id);
        categoryRepository.delete(category);
	}
}
