package com.CE.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Questions {

	@Id
	private int id;
	private String question;
	private String answer;
	
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
