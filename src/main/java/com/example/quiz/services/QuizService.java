package com.example.quiz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quiz.model.Question;
import com.example.quiz.model.QuestionWrapper;
import com.example.quiz.model.Quiz;
import com.example.quiz.model.Responce;
import com.example.quiz.repository.QuestionRepo;
import com.example.quiz.repository.QuizRepo;

@Service
public class QuizService {

	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionRepo questionRepo;
	
	public ResponseEntity<String> createQuiz(String categorey, int numQ, String title) {
	
		List<Question> questions =  questionRepo.findRandomQuestionByCategoryAndTitle(categorey, numQ);
		
		Quiz quiz = new Quiz();
		
		quiz.setTitle(title);		
		quiz.setquestions(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<String>("succes", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getAllquestion(Long id) {
		
		Optional<Quiz> quiz = quizRepo.findById(id);
		
		List<Question> questionsFromDb = quiz.get().getquestions();
		
		List<QuestionWrapper> questionsForUsers = new ArrayList<>();
		
		for(Question q: questionsFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUsers.add(qw);
		}
		
		return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
		
	}

	public ResponseEntity<Integer> calculateResult(Long id, List<Responce> responces) {
	
		Quiz quiz =  quizRepo.findById(id).get();
		
		List<Question> questions = quiz.getquestions();
		
		int right = 0;
		
		int i = 0;
		
		for (Responce reponse : responces) {
			if(reponse.getResponce().equals(questions.get(i).getRightAnswer())) {
				right ++;
			}
			i++;		
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}

}
