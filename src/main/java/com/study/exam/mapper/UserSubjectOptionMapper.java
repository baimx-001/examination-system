package com.study.exam.mapper;

import com.study.exam.entity.UserSubjectOption;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserSubjectOptionMapper extends Mapper<UserSubjectOption> {
    UserSubjectOption getOptionByUserIdAndSubjectId(@Param("userId") int userId, @Param("sujectId") Integer sujectId);

    List<UserSubjectOption> getOptionsByUserId(@Param("userId") int userId);
}