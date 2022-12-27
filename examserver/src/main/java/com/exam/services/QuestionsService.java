package com.exam.services;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;

import java.util.Set;

public interface QuestionsService
{
	public Questions addQuestions(Questions questions);

	public Questions updateQuestions(Questions questions);

	public Set<Questions> getQuestions();

	public Questions getQuestions(Long quesid);

	public Set<Questions> getQuestionOfQuiz(Quiz quiz);

	public void delete(Long quesid);
}
