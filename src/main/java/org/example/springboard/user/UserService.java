package org.example.springboard.user;

import org.example.springboard.Const;
import org.example.springboard.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private HttpSession hs;

    public int join(UserEntity entity){
        entity.setUpw(BCrypt.hashpw(entity.getUpw(),BCrypt.gensalt()));
        int result = mapper.insJoin(entity);
        return result;
    }

    public int login(UserEntity param){
        UserEntity entity = null;
        try {
            entity = mapper.selLogin(param);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        System.out.println(param);
        System.out.println(entity);
        if(entity==null){
            return 2; // id없음
        }
        if(BCrypt.checkpw(param.getUpw(),entity.getUpw())){
            System.out.println(entity);
            entity.setUpw(null);
            entity.setRdt(null);
            hs.setAttribute(Const.LOGIN_USER,entity);
            return 1;
        }else {
            return 3;
        }
    }
}
