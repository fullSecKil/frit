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
 * 客户管理对象 crm_customer
 *
 * @author jeethink
 * @date 2020-04-02
 */
@TableName("crm_customer")
@Alias("CrmCustomer")
public class CrmCustomer implements Serializable {
    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    @ExcelIgnore
    private Long customerId;

    /**
     * 客户获取时间
     */
    @ExcelIgnore
    private Date getDate;

    /**
     * 客户类型
     */
    @ExcelIgnore
    private String customerType;

    /**
     * 客户名称
     */
    @ExcelProperty(value = "客户名称")
    private String customerName;

    /**
     * 客户简称
     */
    @ExcelIgnore
    private String nameShort;

    /**
     * 公司座机
     */
    @ExcelProperty(value = "电话")
    private String telephone;

    /**
     * 手机
     */
    @ExcelIgnore
    private String mobile;

    /**
     * 邮箱
     */
    @ExcelIgnore
    private String email;

    /**
     * 传值
     */
    @ExcelIgnore
    private String fax;

    /**
     * 网址
     */
    @ExcelIgnore
    private String website;

    /**
     * 邮编
     */
    @ExcelIgnore
    private String zip;

    /**
     * 国家
     */
    @ExcelIgnore
    private String country;

    /**
     * 省份
     */
    @ExcelProperty(value = "省份")
    private String province;

    /**
     * 城市
     */
    @ExcelProperty(value = "市")
    private String city;

    /**
     * 地区
     */
    @ExcelProperty(value = "区")
    private String region;

    /**
     * 意向产品（后期应可以选择）
     */
    @ExcelIgnore
    private String intrestedProdcut;

    /**
     * 所属行业（字典型）
     */
    @ExcelProperty(value = "行业")
    private String industry;

    /**
     * 客户状态
     */
    @ExcelIgnore
    private String customerStatus;

    /**
     * 客户来源
     */
    @ExcelIgnore
    private String customerSource;

    /**
     * 客户等级
     */
    @ExcelProperty(value = "客户级别")
    private String customerDegree;

    /**
     * 客户优先级
     */
    @ExcelIgnore
    private String customerPriority;

    /**
     * 客户信誉度
     */
    @ExcelIgnore
    private String customerCredit;

    /**
     * 客户成熟度
     */
    @ExcelIgnore
    private String customerMaturity;

    /**
     * 客户类别
     */
    @ExcelIgnore
    private String customerCategory;

    /**
     * 年收入
     */
    @ExcelIgnore
    private String annualIncome;

    /**
     * 客户地址
     */
    @ExcelProperty(value = "详细地址")
    private String address;

    /**
     * 原负责人
     */
    @ExcelProperty(value = "客户所有人")
    private String sourceBelongTo;

    /**
     * 负责人
     */
    @ExcelProperty(value = "客户所有人")
    private String belongTo;

    /**
     * 转交时间
     */
    //@Excel(name = "转交时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ExcelIgnore
    private Date trasferDate;

    /**
     * 转交人
     */
    //@Excel(name = "转交人")
    @ExcelIgnore
    private String trasferTo;

    /**
     * 是否共享客户
     */
    @ExcelIgnore
    private String isShare;

    /**
     * 共享时间
     */
    @ExcelIgnore
    private Date shareDate;

    /**
     * 头像（保留）
     */
    //@Excel(name = "头像", readConverterExp = "保留")
    @ExcelIgnore
    private String avatar;

    /**
     * qq（保留）
     */
    //@Excel(name = "qq", readConverterExp = "保留")
    @ExcelIgnore
    private String qq;

    /**
     * 删除标识
     */
    @ExcelIgnore
    private String delFlag;
    //    订单总金额
    @ExcelIgnore
    private Double totalSum;

    @ExcelIgnore
    private Long followDays;

    @ExcelIgnore
    private Long followStatus;


    /**
     * 创建者
     */
    @ExcelIgnore
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat("yyyy-MM-dd HH:mm")
    @ExcelProperty(value = "创建日期")
    private Date createTime;

    /**
     * 更新者
     */
    @ExcelProperty(value = "最新修改人")
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelIgnore
    private Date updateTime;

    /**
     * 备注
     */
    @ExcelIgnore
    private String remark;

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setIntrestedProdcut(String intrestedProdcut) {
        this.intrestedProdcut = intrestedProdcut;
    }

    public String getIntrestedProdcut() {
        return intrestedProdcut;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerSource(String customerSource) {
        this.customerSource = customerSource;
    }

    public String getCustomerSource() {
        return customerSource;
    }

    public void setCustomerDegree(String customerDegree) {
        this.customerDegree = customerDegree;
    }

    public String getCustomerDegree() {
        return customerDegree;
    }

    public void setCustomerPriority(String customerPriority) {
        this.customerPriority = customerPriority;
    }

    public String getCustomerPriority() {
        return customerPriority;
    }

    public void setCustomerCredit(String customerCredit) {
        this.customerCredit = customerCredit;
    }

    public String getCustomerCredit() {
        return customerCredit;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerMaturity(String customerMaturity) {
        this.customerMaturity = customerMaturity;
    }

    public String getCustomerMaturity() {
        return customerMaturity;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setSourceBelongTo(String sourceBelongTo) {
        this.sourceBelongTo = sourceBelongTo;
    }

    public String getSourceBelongTo() {
        return sourceBelongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setTrasferDate(Date trasferDate) {
        this.trasferDate = trasferDate;
    }

    public Date getTrasferDate() {
        return trasferDate;
    }

    public void setTrasferTo(String trasferTo) {
        this.trasferTo = trasferTo;
    }

    public String getTrasferTo() {
        return trasferTo;
    }

    public void setIsShare(String isShare) {
        this.isShare = isShare;
    }

    public String getIsShare() {
        return isShare;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQq() {
        return qq;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Long getFollowDays() {
        return followDays;
    }

    public void setFollowDays(Long followDays) {
        this.followDays = followDays;
    }

    public Long getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Long followStatus) {
        this.followStatus = followStatus;
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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}