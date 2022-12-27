package com.exam.services.impl;

import com.exam.model.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService
{
	@Autowired
	private QuizRepository quizRepository;
	@Override
	public Quiz addQuiz(Quiz quiz)
	{
		return quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuizzes(Quiz quiz)
	{
		return quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuiz()
	{
		return new HashSet<>(quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long qid)
	{
		return quizRepository.findById(qid).get();
	}

	@Override
	public void delete(Long qid)
	{
		quizRepository.deleteById(qid);
	}
}