package com.study.exam.service;

import com.study.exam.entity.Subject;

public interface SubjectService {
    public String submitSubject(String title, String optionA,
                                String optionB, String optionC,
                                String optionD, String rightOption,
                                double score);

    Subject getSubjectByIdAndType(String id, String type);
}
