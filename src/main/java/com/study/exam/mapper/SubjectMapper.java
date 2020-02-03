package com.study.exam.mapper;

import com.study.exam.entity.Subject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SubjectMapper extends Mapper<Subject> {
    public Subject findInitSubject();
    public Subject findPrevSubject(@Param("id") Integer id);
    public Subject findNextSubject(@Param("id") Integer id);

    List<Subject> getSubjectsByIds(@Param("list") List<Integer> subjectIdList);
}