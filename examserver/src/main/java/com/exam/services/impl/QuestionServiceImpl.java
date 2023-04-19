package com.exam.services.impl;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionsService
{
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Questions addQuestions(Questions questions)
	{
		return questionRepository.save(questions);
	}

	@Override
	public Questions updateQuestions(Questions questions)
	{
		return questionRepository.save(questions);
	}

	@Override
	public Set<Questions> getQuestions()
	{
		return new HashSet<>(questionRepository.findAll());
	}

	@Override
	public Questions getQuestions(Long quesid)
	{
		return questionRepository.findById(quesid).get();
	}

	@Override
	public Set<Questions> getQuestionOfQuiz(Quiz quiz)
	{
		return questionRepository.findByQuiz(quiz);
	}

	@Override
	public void delete(Long quesid)
	{
		questionRepository.deleteById(quesid);

	}
}
