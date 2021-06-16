package com.example.boot25test.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户联系人对象 crm_person
 *
 * @author jeethink
 * @date 2020-04-02
 */
@TableName("crm_person")
@Alias("CrmPerson")
public class CrmPerson implements Serializable {
    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    /**
     * 联系人ID
     */
    @ExcelIgnore
    private Long personId;

    /**
     * 所属客户
     */
    @ExcelIgnore
    private Long customerId;

    /**
     * 联系人名称
     */
    @ExcelProperty(value = "姓名")
    private String personName;

    /**
     * 联系人英文名
     */

    @ExcelProperty(value = "公司名称")
    private String englishName;

    /**
     * 职务
     */
    @ExcelProperty(value = "职务")
    private String duty;

    /**
     * 固定电话
     */
    @ExcelProperty(value = "固定电话")
    private String telephone;

    /**
     * 手机
     */
    @ExcelProperty(value = "手机")
    private String mobile;

    /**
     * 用户邮箱
     */
    @ExcelProperty(value = "电子邮件")
    private String email;

    /**
     * 传真
     */
    @ExcelIgnore
    private String fax;

    /**
     * qq
     */
    @ExcelIgnore
    private String qq;

    /**
     * 微信
     */
    @ExcelIgnore
    private String wechat;

    /**
     * 旺旺
     */
    @ExcelIgnore
    private String wangwang;

    /**
     * MSN
     */
    @ExcelIgnore
    private String msn;

    /**
     * 爱好
     */
    @ExcelIgnore
    private String hobby;

    /**
     * 性别
     */
    @ExcelIgnore
    private String sex;

    /**
     * 婚否   字典
     */
    @ExcelIgnore
    private String marriage;

    /**
     * 出生日期
     */
    @ExcelIgnore
    private Date birthday;

    /**
     * 决策等级（字典 分星展示）
     */
    @ExcelIgnore
    private String personDecisionLevel;

    /**
     * 证件类型
     */
    @ExcelIgnore
    private String idType;

    /**
     * 证件号码
     */
    @ExcelIgnore
    private String idNum;

    /**
     * 家庭电话
     */
    @ExcelIgnore
    private String homeMobile;

    /**
     * 家庭住址
     */
    @ExcelIgnore
    private String homeAddress;

    /**
     * 头像（保留）
     */
    @ExcelIgnore
    private String avatar;

    /**
     * 删除标识
     */
    @ExcelIgnore
    private String delFlag;

    /**
     * 创建者
     */
    @ExcelProperty(value = "联系人所有人")
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat("yyyy-MM-dd HH:mm")
    @ExcelProperty(value = "创建日期")
    private Date createTime;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getWangwang() {
        return wangwang;
    }

    public void setWangwang(String wangwang) {
        this.wangwang = wangwang;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPersonDecisionLevel() {
        return personDecisionLevel;
    }

    public void setPersonDecisionLevel(String personDecisionLevel) {
        this.personDecisionLevel = personDecisionLevel;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getHomeMobile() {
        return homeMobile;
    }

    public void setHomeMobile(String homeMobile) {
        this.homeMobile = homeMobile;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CrmPerson{" +
                "personId=" + personId +
                ", customerId=" + customerId +
                ", personName='" + personName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", duty='" + duty + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", wangwang='" + wangwang + '\'' +
                ", msn='" + msn + '\'' +
                ", hobby='" + hobby + '\'' +
                ", sex='" + sex + '\'' +
                ", marriage='" + marriage + '\'' +
                ", birthday=" + birthday +
                ", personDecisionLevel='" + personDecisionLevel + '\'' +
                ", idType='" + idType + '\'' +
                ", idNum='" + idNum + '\'' +
                ", homeMobile='" + homeMobile + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", avatar='" + avatar + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}