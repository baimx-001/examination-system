package com.study.exam.service.impl;

import com.study.exam.entity.User;
import com.study.exam.mapper.UserMapper;
import com.study.exam.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public boolean checkLogin(String username, String password) {
        User user=userMapper.findByUserNameAndPassWord(username,password);
        if(user!=null){
            return true;
        }
        return false;
    }
}
