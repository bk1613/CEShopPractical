package com.CE.service;

import java.util.List;

import com.CE.domain.Questions;

public interface QuestionService {

	public Questions saveQuestion(Questions que);
	
	public List<Questions> findallquestions();
	
	public Questions findbyId(int id);
	
}
