package com.example.quiz.model;

public class Responce {

	private Integer id;
	
	private String responce;

	public Responce(Integer id, String responce) {
		super();
		this.id = id;
		this.responce = responce;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResponce() {
		return responce;
	}

	public void setResponce(String responce) {
		this.responce = responce;
	}
}
