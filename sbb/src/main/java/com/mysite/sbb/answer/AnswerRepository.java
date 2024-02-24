package com.mysite.sbb.answer;

import org.springframework.data.jpa.repository.JpaRepository;

// Answer entity로 repository 생성. 기본키는 Interger
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}