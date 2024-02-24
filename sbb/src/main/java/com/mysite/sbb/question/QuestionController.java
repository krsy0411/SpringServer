package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor는 롬복(Lombok)이 제공하는 애너테이션으로, final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 주는 역할을 한다
@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;

    @GetMapping("/question/list")
    // 매개변수로 Model을 지정하면 객체가 자동으로 생성 : Model 객체는 따로 생성할 필요 없이 컨트롤러의 메서드에 매개변수로 지정하기만 하면 스프링 부트가 자동으로 Model 객체를 생성
    public String list(Model model) {
    	
    	// 직접 repository에서부터 데이터를 가져오기보다는 서비스를 거쳐 데이터를 가져오도록 변경
    	// 항상 Controller -> Service -> Repository 순서로 접근하는 과정을 거쳐 데이터를 처리하도록 하자 
    	List<Question> questionList = this.questionService.getList();
        // Model 객체에 ‘questionList’라는 이름으로 저장 : Model 객체는 자바 클래스(Java class)와 템플릿(template) 간의 연결 고리 역할
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
