package com.exam.repository;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Long>
{
	 public Set<Questions> findByQuiz(Quiz quiz);
}
