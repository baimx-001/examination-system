package com.study.exam.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "subject")
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "optionA")
    private String optiona;

    @Column(name = "optionB")
    private String optionb;

    @Column(name = "optionC")
    private String optionc;

    @Column(name = "optionD")
    private String optiond;

    @Column(name = "right_option")
    private String rightOption;

    private double score;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public Subject(String title, String optiona,
                   String optionb, String optionc,
                   String optiond, String rightOption, double score) {
        this.title = title;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optiond = optiond;
        this.rightOption = rightOption;
        this.score = score;
    }
    public Subject(){

    }

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return optionA
     */
    public String getOptiona() {
        return optiona;
    }

    /**
     * @param optiona
     */
    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    /**
     * @return optionB
     */
    public String getOptionb() {
        return optionb;
    }

    /**
     * @param optionb
     */
    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    /**
     * @return optionC
     */
    public String getOptionc() {
        return optionc;
    }

    /**
     * @param optionc
     */
    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    /**
     * @return optionD
     */
    public String getOptiond() {
        return optiond;
    }

    /**
     * @param optiond
     */
    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    /**
     * @return right_option
     */
    public String getRightOption() {
        return rightOption;
    }

    /**
     * @param rightOption
     */
    public void setRightOption(String rightOption) {
        this.rightOption = rightOption;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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