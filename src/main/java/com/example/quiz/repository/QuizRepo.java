package com.example.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz.model.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {

}
