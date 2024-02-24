package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 데이터베이스에서 특정 엔티티 또는 데이터를 찾을 수 없을 때 발생시키는 예외 클래스
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
// RuntimeException 클래스를 상속하는 것은 사용자 정의 예외 클래스를 정의하는 방법 중 하나 : 실행 시 발생하는 예외라는 의미
public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public DataNotFoundException(String message) {
        super(message);
    }
}
