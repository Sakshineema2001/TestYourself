package com.exam.services;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService
{
	public Quiz addQuiz(Quiz quiz);

	public Quiz updateQuizzes(Quiz quiz);

	public Set<Quiz> getQuiz();

	public Quiz getQuiz(Long qid);

	public void delete(Long qid);

	public List<Quiz> getQuizzesOfCategory(Category category);

	public List<Quiz> getActiveQuiz();

	public List<Quiz> getActiveQuizzesOfCategory(Category category);
}
