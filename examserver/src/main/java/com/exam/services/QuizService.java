package com.exam.services;

import com.exam.model.exam.Quiz;

import java.util.Set;

public interface QuizService
{
	public Quiz addQuiz(Quiz quiz);

	public Quiz updateQuizzes(Quiz quiz);

	public Set<Quiz> getQuiz();

	public Quiz getQuiz(Long qid);

	public void delete(Long qid);
}
