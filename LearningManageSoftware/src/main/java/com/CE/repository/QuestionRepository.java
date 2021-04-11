package com.CE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CE.domain.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer> {

}
