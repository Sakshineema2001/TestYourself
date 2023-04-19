package com.exam.repository;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import org.hibernate.engine.jdbc.env.spi.QualifiedObjectNameFormatter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long>
{
	public List<Quiz> findByCategory(Category category);

	public List<Quiz> findByActive(Boolean b);
	public List<Quiz> findByCategoryAndActive(Category category,Boolean b);
}
