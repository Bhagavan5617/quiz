package com.example.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.quiz.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{
	
	List<Question>findByCategorey(String categorey);
	@Query(value = "SELECT * FROM question q WHERE q.categorey = :category  ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategoryAndTitle(@Param("category") String category, @Param("numQ") int numQ);
}
