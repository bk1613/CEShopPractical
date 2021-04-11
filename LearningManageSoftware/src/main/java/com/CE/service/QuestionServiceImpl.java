package com.CE.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CE.domain.Questions;
import com.CE.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionRepository qr;
	
	@Override
	public Questions saveQuestion(Questions que) {
		
		return qr.save(que);
	}

	@Override
	public List<Questions> findallquestions() {
		// TODO Auto-generated method stub
		return qr.findAll();
	}

	@Override
	public Questions findbyId(int id) {
		Optional<Questions> que = qr.findById(id);
		
		if(que.get() != null) {
			return que.get();
		}else {
			return null;
		}
		
	}

}
