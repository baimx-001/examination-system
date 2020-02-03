package com.study.exam.service;
public interface UserService {
    public  int checkLogin(String username,String password);
    public String addUser(String username,String password);
}