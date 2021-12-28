package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService service;
    //bean등록 ( 서블릿 처럼 주솟값이랑 매핑이 되는 객체 ) 을 할수있음
    @GetMapping("/list")
    public void list(Model model){
        List<BoardEntity> list = service.selBoardList();
        model.addAttribute("list",list);
    }

    //글쓰기
    @GetMapping("/write")
    public void write(){}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity){
        System.out.println(entity);
        int result = service.insBoard(entity);
        return "redirect:/board/list";
    }

}
