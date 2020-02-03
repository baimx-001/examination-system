package com.study.exam.service.impl;

import com.study.exam.entity.User;
import com.study.exam.mapper.UserMapper;
import com.study.exam.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {


    @Resource
    UserMapper userMapper;
    @Override
    public int  checkLogin(String username, String password) {
        User user=userMapper.findByUserNameAndPassWord(username,password);
        if(user!=null){
            return user.getId();
        }
        return  0;
    }
    @Override
    public String addUser(String username, String password) {
        if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
            return "添加失败";
        }else {
            User user=new User(username,password);
            int flag=userMapper.insert(user);
            if(flag==1){
                return "添加成功";
            }else {
                return "添加失败";
            }
        }
    }
}
