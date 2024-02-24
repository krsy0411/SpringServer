package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// url상에서 변하는 id값을 얻을 때에는 @PathVariable 애너테이션을 사용 
import org.springframework.web.bind.annotation.PathVariable;
// URL prefix(접두사) 
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

// 앞으로 QuestionController.java에서 URL을 매핑할 때 반드시 /question으로 시작한다는 것을 기억해 두자.
@RequestMapping("/question")
//@RequiredArgsConstructor는 롬복(Lombok)이 제공하는 애너테이션으로, final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 주는 역할을 한다
@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;

	@GetMapping("/list")
    // 매개변수로 Model을 지정하면 객체가 자동으로 생성 : Model 객체는 따로 생성할 필요 없이 컨트롤러의 메서드에 매개변수로 지정하기만 하면 스프링 부트가 자동으로 Model 객체를 생성
    public String list(Model model) {
    	// 직접 repository에서부터 데이터를 가져오기보다는 서비스를 거쳐 데이터를 가져오도록 변경
    	// 항상 Controller -> Service -> Repository 순서로 접근하는 과정을 거쳐 데이터를 처리하도록 하자 
    	List<Question> questionList = this.questionService.getList();
        // Model 객체에 ‘questionList’라는 이름으로 저장 : Model 객체는 자바 클래스(Java class)와 템플릿(template) 간의 연결 고리 역할
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    
    // @GetMapping(value = "/question/detail/{id}")에서 사용한 id와 @PathVariable("id")의 매개변수 이름이 이와 같이 동일해야 한다
	@GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        // Model객체에 "question"이라는 이름으로 저장 : id를 통해 getQuestion을 수행한 질문을 템플릿의 attribute로 저
        model.addAttribute("question", question);
        // Model객체가 연결된 question_detail 템플릿 반
        return "question_detail";
    }
}
