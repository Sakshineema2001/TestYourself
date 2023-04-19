package com.exam.services.impl;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;
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

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category){
		return quizRepository.findByCategory(category);
	}

	@Override
	public List<Quiz> getActiveQuiz()
	{
		return quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category category)
	{
		return quizRepository.findByCategoryAndActive(category,true);
	}
}