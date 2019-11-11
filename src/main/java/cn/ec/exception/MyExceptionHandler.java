package cn.ec.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler extends RuntimeException {

    @ExceptionHandler(Exception.class)

    public String  handlerException(Exception e,HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "666");
        map.put("message", "我是异常消息");
        request.setAttribute("javax.servlet.error.status_code", 500);
        return "forward:/error";
    }

}
