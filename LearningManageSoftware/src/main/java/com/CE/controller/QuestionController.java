package com.CE.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CE.domain.Questions;
import com.CE.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionService qs;
	
	
	@RequestMapping(value = "questionform")
	public String itemPage(Questions ques, Model model) {
		System.out.println("ques");
	
		model.addAttribute("questions", qs.findallquestions());
		return "questionpage";
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity<Questions> addQustions(@RequestBody Questions question){
		
		question = qs.saveQuestion(question);
		
		
		return new ResponseEntity<Questions>(question, HttpStatus.CREATED);
	}

	@PostMapping("/answeredQuestion")
	public ResponseEntity<?> answeredQustions(@RequestBody String jsonString){
		
		JSONObject jsonObject = new JSONObject(jsonString);
		
		
		JSONArray arr = jsonObject.getJSONArray("answers");
		double count = 0;
		for(Object o: arr) {
			
			jsonObject = new JSONObject(o.toString());
			
			Questions que = qs.findbyId(jsonObject.getInt("id"));
			
			if(que.getAnswer().equalsIgnoreCase(jsonObject.getString("answer"))) {
				count++;
			}
			
			
		}
		double db = count/arr.length();
		System.out.println(db);
		JSONObject jsa = new JSONObject();
		jsa.put("percent", db*100+"%");
		return new ResponseEntity<String>(jsa.toString(), HttpStatus.CREATED);
	}
	
	
	@GetMapping("findAllQuestions")
	public ResponseEntity<List<Questions>> addQustions(){
		
		List<Questions> li = qs.findallquestions();
		
		return new ResponseEntity<List<Questions>>(li, HttpStatus.CREATED);
	}
	
}
