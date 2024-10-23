package com.example.quiz.model;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String title;
	
	@ManyToMany
	private List<Question> questions;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getquestions() {
		return questions;
	}

	public void setquestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
