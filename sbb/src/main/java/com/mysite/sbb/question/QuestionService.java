package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

// 원래는 서비스를 통해 엔티티 객체를 DTO객체로 변환하는 일을 처리해줘야함
// 이 책에서는 설명을 줄이기 위해 DTO객체를 별도로 사용하지않고, 엔티티 객체를 컨트롤러와 타임리프에서 그대로 사용할 예

@RequiredArgsConstructor
@Service
public class QuestionService {
	// questionRepository 객체는 @RequiredArgsConstructor에 의해 생성자 방식으로 주입된다
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
    	// QuestionRepository의 findAll 메서드를 사용하여 질문 목록 데이터인 questionList를 생성
        return this.questionRepository.findAll();
    }
}
