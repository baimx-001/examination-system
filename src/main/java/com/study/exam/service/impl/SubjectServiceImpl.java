package com.study.exam.service.impl;

import com.study.exam.entity.Subject;
import com.study.exam.mapper.SubjectMapper;
import com.study.exam.service.SubjectService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    SubjectMapper subjectMapper;

    @Override
    public String submitSubject(String title, String optionA,
                                String optionB, String optionC,
                                String optionD, String rightOption,
                                double score) {
        if(StringUtil.isEmpty(title)||StringUtil.isEmpty(optionA)||
                StringUtil.isEmpty(optionB)||StringUtil.isEmpty(optionC)||
                StringUtil.isEmpty(optionD)||StringUtil.isEmpty(rightOption)||(Double)score==null){
            return "添加失败";
        }else {
            Subject subject=new Subject(title,optionA,optionB,optionC,optionD,rightOption,score);
            int flag = subjectMapper.insert(subject);
            if (flag==1){
                return "添加成功";
            }else {
                return "添加失败";
            }
        }
    }

    @Override
    public Subject getSubjectByIdAndType(String id, String type) {
        if("init".equals(type)){
            return subjectMapper.findInitSubject();
        }else if("prev".equals(type)){

        }else {

        }
        return null;
    }


}
