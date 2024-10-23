package com.example.quiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	public List<Question> getAllQuestions(){
		
		return questionRepo.findAll();
	}

	
	public List<Question> postquestions(List<Question> question) {
		return questionRepo.saveAll(question);
	}


	public List<Question> getQuestionByCategorey(String categorey) {
		
		return questionRepo.findByCategorey(categorey);
	}
}
