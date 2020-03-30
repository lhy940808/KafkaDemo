package com.lhy.boot.shardingSphere.model;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.member_id
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private Long memberId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.member_name
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private String memberName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.nick_name
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private String nickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.account_no
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private String accountNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.password
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.age
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.birth_date
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private Date birthDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.ebl_flag
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private String eblFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.del_flag
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private String delFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.description
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.create_time
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.update_time
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_member
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.member_id
     *
     * @return the value of t_member.member_id
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.member_id
     *
     * @param memberId the value for t_member.member_id
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.member_name
     *
     * @return the value of t_member.member_name
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.member_name
     *
     * @param memberName the value for t_member.member_name
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.nick_name
     *
     * @return the value of t_member.nick_name
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.nick_name
     *
     * @param nickName the value for t_member.nick_name
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.account_no
     *
     * @return the value of t_member.account_no
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.account_no
     *
     * @param accountNo the value for t_member.account_no
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.password
     *
     * @return the value of t_member.password
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.password
     *
     * @param password the value for t_member.password
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.age
     *
     * @return the value of t_member.age
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.age
     *
     * @param age the value for t_member.age
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.birth_date
     *
     * @return the value of t_member.birth_date
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.birth_date
     *
     * @param birthDate the value for t_member.birth_date
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.ebl_flag
     *
     * @return the value of t_member.ebl_flag
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public String getEblFlag() {
        return eblFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.ebl_flag
     *
     * @param eblFlag the value for t_member.ebl_flag
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setEblFlag(String eblFlag) {
        this.eblFlag = eblFlag == null ? null : eblFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.del_flag
     *
     * @return the value of t_member.del_flag
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.del_flag
     *
     * @param delFlag the value for t_member.del_flag
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.description
     *
     * @return the value of t_member.description
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.description
     *
     * @param description the value for t_member.description
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.create_time
     *
     * @return the value of t_member.create_time
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.create_time
     *
     * @param createTime the value for t_member.create_time
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.update_time
     *
     * @return the value of t_member.update_time
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.update_time
     *
     * @param updateTime the value for t_member.update_time
     *
     * @mbg.generated Mon Mar 30 23:10:47 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}