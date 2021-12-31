package org.example.springboard.user;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboard.user.model.UserEntity;

@Mapper
public interface UserMapper {
    //로그인
    UserEntity selLogin(UserEntity entity);
    //회원가입
    int insJoin(UserEntity entity);
}
