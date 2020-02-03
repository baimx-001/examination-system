package com.study.exam.service.impl;

import com.study.exam.entity.Subject;
import com.study.exam.entity.UserSubjectOption;
import com.study.exam.mapper.SubjectMapper;
import com.study.exam.mapper.UserSubjectOptionMapper;
import com.study.exam.service.SubjectService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    SubjectMapper subjectMapper;

    @Resource
    UserSubjectOptionMapper userSubjectOptionMapper;

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
    public Subject getSubjectByIdAndType(Integer id, String type,String option,int userId) {
        if("init".equals(type)){
            return subjectMapper.findInitSubject();
        }else if("prev".equals(type)){
            saveUserSubjectOption(id,option,userId);
            return subjectMapper.findPrevSubject(id);
        }else {
            saveUserSubjectOption(id,option,userId);
            return subjectMapper.findNextSubject(id);
        }
    }

    @Override
    public int submitSubjects(Integer id, String option, int userId) {
        saveUserSubjectOption(id, option, userId);
        return getScoreByUserId(userId);
    }

    private int getScoreByUserId(int userId) {
        List<UserSubjectOption> list=userSubjectOptionMapper.getOptionsByUserId(userId);
        List<Integer> subjectIdList=new ArrayList<Integer>();
        for(UserSubjectOption subjectOption:list){
            subjectIdList.add(subjectOption.getSubjectid());
        }
        List<Subject> subjectList = subjectMapper.getSubjectsByIds(subjectIdList);
        int score = 0;
        for (UserSubjectOption subjectOption:list){
            for (Subject subject:subjectList){
                if (subjectOption.getSubjectid().equals(subject.getId())
                    &&subjectOption.getOptioin().equals(subject.getRightOption())){
                    score += subject.getScore();
                }
            }
        }
        return score;
    }

    private void saveUserSubjectOption(Integer sujectId,String option,int userId){
        UserSubjectOption option1 = userSubjectOptionMapper.getOptionByUserIdAndSubjectId(userId,sujectId);
        if (option1!=null){
            if (!option.equals(option1.getOptioin())){
                option1.setOptioin(option);
                userSubjectOptionMapper.updateByPrimaryKey(option1);
            }
        }else {
            UserSubjectOption result = new UserSubjectOption();
            result.setSubjectid(sujectId);
            result.setOptioin(option);
            result.setUserid(userId);
            userSubjectOptionMapper.insert(result);
        }

    }

    @Override
    public int findScore(int userId) {
        return getScoreByUserId(userId);
    }
}
