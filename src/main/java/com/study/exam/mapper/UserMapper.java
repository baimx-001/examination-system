package com.study.exam.mapper;

import com.study.exam.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserMapper extends Mapper<User> {
    public User findByUserNameAndPassWord(@Param("username") String username, @Param("password") String password);

}