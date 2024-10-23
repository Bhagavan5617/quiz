package com.example.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.model.Question;
import com.example.quiz.services.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	
	private QuestionService questionService;
	
	
	
	@GetMapping("allquestions")
	public List<Question> getAllQusetions() {
		return questionService.getAllQuestions();
	}
	
	@PostMapping("postQuestions")
	public List<Question> postQuestions(@RequestBody List<Question> question) {
		return  questionService.postquestions(question);
	}
	
	@GetMapping("categorey/{categorey}")
	public List<Question> getQuestionByCategorey(@PathVariable String categorey){
		
		return  questionService.getQuestionByCategorey(categorey);
	}

}
