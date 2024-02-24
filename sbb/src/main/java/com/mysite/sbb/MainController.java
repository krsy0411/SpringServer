package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	// sbb url 매핑 
    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "안녕하세요 sbb에 오신것을 환영합니다.";
    }
    
    // 루트 url 매핑
    @GetMapping("/")
    public String root() {
    	// /question/list URL로 페이지를 리다이렉트하라는 명령어  
        return "redirect:/question/list";
    }
}
