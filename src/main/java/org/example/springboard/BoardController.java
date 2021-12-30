package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    //글쓰기 겟
    @GetMapping("/write")
    public void write(){}
    //글쓰기 포스트
    @PostMapping("/write")
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr){
        System.out.println(entity);
        int result = service.insBoard(entity);
        if(result==0){
//            reAttr.addAttribute("dsad"," "); 쿼리 스트링 생성
            reAttr.addFlashAttribute("msg","fail to write");
            reAttr.addFlashAttribute("data",entity);
            return "redirect:/board/write";
        }
        return "redirect:/board/list";
    }
    //디테일
    @GetMapping("/detail")
    public void detail(Model model,BoardEntity entity){
        service.updBoardHitsUp(entity);
        model.addAttribute("data",service.selBoard(entity));
    }
    //삭제
    @GetMapping("/delete")
    public String del(BoardEntity entity,RedirectAttributes reAttr){
        int result = service.delBoard(entity);
        if(result==0){
            reAttr.addFlashAttribute("msg","fail to delete");
            return "redirect:/board/detail?iboard="+entity.getIboard();
        }
        return "redirect:/board/list";
    }
    //수정
    @GetMapping("/mod")
    public void upd(Model model, BoardEntity entity, HttpServletRequest req) throws Exception{
        /*
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(res); //addFlashAttribute 했는값 가져오는 방법
        BoardEntity data = map != null ? (BoardEntity) map.get("data") : service.selBoard(entity);
        model.addAttribute("data", data);
         */
        if(!model.containsAttribute("msg")){
            model.addAttribute("data",service.selBoard(entity));
        }
    }
    @PostMapping("/mod")
    public String upd(BoardEntity entity,RedirectAttributes reAttr){
        System.out.println(entity);
        int result = service.updBoard(entity);
        if(result==0){
            reAttr.addFlashAttribute("data",entity);
            reAttr.addFlashAttribute("msg","fail to change");
            return "redirect:/board/mod?iboard="+entity.getIboard();
        }
        return "redirect:/board/detail?iboard="+entity.getIboard();
    }
}
