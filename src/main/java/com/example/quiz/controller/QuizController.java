package com.example.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.model.Question;
import com.example.quiz.model.QuestionWrapper;
import com.example.quiz.model.Responce;
import com.example.quiz.services.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String categorey, @RequestParam int numQ, @RequestParam String title){
		return quizService.createQuiz(categorey, numQ,title);
	}

	
	@GetMapping("get/{id}")
	public  ResponseEntity<List<QuestionWrapper>> getAllQuestions(@PathVariable Long id){
		
		return quizService.getAllquestion(id);
	}
	
	@PostMapping("submit/{id}")
	public  ResponseEntity<Integer>  submitQuiz(@PathVariable Long id, @RequestBody List<Responce> responces){
		
		return quizService.calculateResult(id, responces);
	}
}
