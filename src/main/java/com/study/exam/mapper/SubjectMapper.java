package com.study.exam.mapper;

import com.study.exam.entity.Subject;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface SubjectMapper extends Mapper<Subject> {
    public Subject findInitSubject();
}