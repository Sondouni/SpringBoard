package org.example.springboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class BoardController {
    //bean등록 ( 서블릿 처럼 주솟값이랑 매핑이 되는 객체 ) 을 할수있음
    @RequestMapping("/list")
    public String list(){
        System.out.println("boardcontroller - list method called");
        return "list";
    }
}
