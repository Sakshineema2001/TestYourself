package com.exam.controller;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;
import com.exam.services.QuestionsService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/questions")
@CrossOrigin("*")
public class QuestionController
{
	@Autowired
	private QuestionsService questionsService;

	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public ResponseEntity<Questions> addQuestions(@RequestBody Questions questions){
		Questions questions1 = questionsService.addQuestions(questions);
		return ResponseEntity.ok(questions1);
	}

	@PutMapping("/")
	public ResponseEntity<Questions> updateQuestions(@RequestBody Questions questions){
		Questions questions1 = questionsService.updateQuestions(questions);
		return ResponseEntity.ok(questions1);
	}
	@GetMapping("/")
	public Set<Questions> getAllQuestions(){
		return questionsService.getQuestions();
	}

	@GetMapping("/{quesid}")
	public Questions getQuestionsById(@PathVariable Long quesid){
		return questionsService.getQuestions(quesid);
	}

	@DeleteMapping("/{quesid}")
	public void deleteQuestions(@PathVariable Long quesid){
		questionsService.delete(quesid);
	}

	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable Long qid){
//		Quiz quiz = new Quiz();
//		quiz.setQid(qid);
//		Set<Questions> questionsQuiz = this.questionsService.getQuestionOfQuiz(quiz);
//		return ResponseEntity.ok(questionsQuiz);

		Quiz quiz = quizService.getQuiz(qid);
		Set<Questions> questions = quiz.getQuestionsSet();
		List list = new ArrayList(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
			list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions() + 1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);


	}

	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getAllQuestionsOfQuiz(@PathVariable Long qid){
				Quiz quiz = new Quiz();
				quiz.setQid(qid);
				Set<Questions> questionsQuiz = this.questionsService.getQuestionOfQuiz(quiz);
				return ResponseEntity.ok(questionsQuiz);
	}

	@PostMapping("/eval-quiz")
	public ResponseEntity<?> EvalQuiz(@RequestBody List<Questions> questions){
		double marksGot = 0 ;
		int attempted = 0;
		int correctAnswers = 0;
		for (Questions q:questions){
			Questions question = this.questionsService.getQues(q.getQuesId());
			System.out.println("----------gg-" + question.toString());
			System.out.println("----getAnswer------" + question.getAnswer().trim());
			System.out.println("-----getGivenAnswers------" + q.getGivenAnswers().trim());
			if(question.getAnswer().trim().equals(q.getGivenAnswers().trim())){
               correctAnswers++;
				double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
				System.out.println("-----marksSingle-----------" + marksSingle);
				marksGot += marksSingle;
			}
			if(q.getGivenAnswers() != null || !q.getGivenAnswers().trim().equals("") ){
				attempted++;
			}
		}
		Map<Object,Object>  map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
		return ResponseEntity.ok(map);
	}
}
