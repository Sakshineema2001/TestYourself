package com.exam.controller;

import com.exam.model.exam.Quiz;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController
{
	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
		Quiz quiz1 = quizService.addQuiz(quiz);
		return ResponseEntity.ok(quiz1);
	}

	@PutMapping("/")
	public Quiz updateQuiz(@RequestBody Quiz quiz){
		return quizService.updateQuizzes(quiz);
	}

	@GetMapping("/{qid}")
	public Quiz getQuiz(@PathVariable Long qid){
		return quizService.getQuiz(qid);
	}

	@GetMapping("/")
	public Set<Quiz> getAllQuiz(){
		return quizService.getQuiz();
	}

	@DeleteMapping("/{qid}")
	public void deletequiz(@PathVariable Long qid){
		quizService.delete(qid);
	}
}
