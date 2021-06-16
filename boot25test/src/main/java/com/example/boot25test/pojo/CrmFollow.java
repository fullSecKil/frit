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
 * 客户跟进记录对象 crm_follow
 *
 * @author jeethink
 * @date 2020-03-10
 */

@TableName("crm_follow")
@Alias("CrmFollow")
public class CrmFollow implements Serializable {
    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    /**
     * 跟进ID
     */
    @ExcelIgnore
    private Long followId;

    /**
     * 客户id
     */
    @ExcelIgnore
    private Long customerId;


    /**
     * 跟进时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat("yyyy-MM-dd HH:mm")
    @ExcelProperty(value = "发布时间")
    private Date followDate;

    /**
     * 跟进内容
     */
    @ExcelProperty(value = "活动记录内容")
    private String followContent;

    /**
     * 跟进类型
     */
    @ExcelProperty(value = "活动记录类型")
    private String followType;

    /**
     * 跟进状态
     */
    @ExcelProperty(value = "来自")
    private String followStatus;

    /**
     * 线索id
     */
    @ExcelIgnore
    private Long clueId;

    /**
     * 线索主题
     */
    @ExcelIgnore
    private String productInfo;

    /**
     * 删除标识
     */
    @ExcelIgnore
    private String delFlag;

    @ExcelIgnore
    private Date nextFollowDate;

    @ExcelIgnore
    private Integer followAck;

    /**
     * 创建者
     */
    @ExcelProperty(value = "发布人")
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat("yyyy-MM-dd HH:mm")
    @ExcelProperty(value = "发布时间")
    private Date createTime;

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getFollowDate() {
        return followDate;
    }

    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }

    public String getFollowContent() {
        return followContent;
    }

    public void setFollowContent(String followContent) {
        this.followContent = followContent;
    }

    public String getFollowType() {
        return followType;
    }

    public void setFollowType(String followType) {
        this.followType = followType;
    }

    public String getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus;
    }

    public Long getClueId() {
        return clueId;
    }

    public void setClueId(Long clueId) {
        this.clueId = clueId;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Date getNextFollowDate() {
        return nextFollowDate;
    }

    public void setNextFollowDate(Date nextFollowDate) {
        this.nextFollowDate = nextFollowDate;
    }

    public Integer getFollowAck() {
        return followAck;
    }

    public void setFollowAck(Integer followAck) {
        this.followAck = followAck;
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
}
