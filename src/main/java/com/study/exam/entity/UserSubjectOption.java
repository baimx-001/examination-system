package com.study.exam.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_subject_option")
public class UserSubjectOption {
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "userId")
    private Integer userid;

    @Column(name = "subjectId")
    private Integer subjectid;

    private String optioin;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return subjectId
     */
    public Integer getSubjectid() {
        return subjectid;
    }

    /**
     * @param subjectid
     */
    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    /**
     * @return optioin
     */
    public String getOptioin() {
        return optioin;
    }

    /**
     * @param optioin
     */
    public void setOptioin(String optioin) {
        this.optioin = optioin;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}