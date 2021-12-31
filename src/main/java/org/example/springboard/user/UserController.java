package org.example.springboard.user;

import org.example.springboard.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/login")
    public void login(){}
    @PostMapping("/login")
    public String loginProc(UserEntity entity, RedirectAttributes reAttr){
        int result = service.login(entity);
        switch (result){
            case 0:
                reAttr.addFlashAttribute("msg","error");
                break;
            case 1:
                return "redirect:/board/list";
            case 2:
                reAttr.addFlashAttribute("msg","check your ID");
                break;
            case 3:
                reAttr.addFlashAttribute("msg","check your PW");
                break;
        }
        return "redirect:/user/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession hs, HttpServletRequest req){
        hs.invalidate();
        //전 페이지 이동
        String referer = req.getHeader("Referer");
        if(referer==null){
            referer = "/user/login";
        }
        return "redirect:"+referer;
    }

    //회원가입
    @GetMapping("/join")
    public void join(){}
    @PostMapping("/join")
    public String joinProc(UserEntity entity){
        int result = service.join(entity);
        return "redirect:/user/login";
    }
}
