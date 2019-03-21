package com.pigbaby.demo.beans;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * NewsProgram
 */
public class NewsProgram implements Serializable {
    private static final long serialVersionUID = 1L;

    private String programId;/* 主键ID */

    private String name;/* 栏目名称 */

    private NewsProgram parentNewsProgram;/* 父级栏目 */

    private List<NewsProgram> childNewsPrograms = new ArrayList<NewsProgram>(0);/* 子栏目集合 */

    private String siteId;/* 栏目所属站点 */

    private String linkUrl;/* 链接地址 */

    private Integer orderNo;/* 排序号 */

    private String levelCode;/* 层级编码 */

    private String showfashion;/* 显示方式 */

    private Integer isPublic;/* 是否公开 0:否 1:是 */

    private String code;/* 栏目标识 便于页面获取 */

    private Integer indexPageProgram;/* 是否首页新闻栏目 0:否 1:是 */

    private Integer isZhuanti;/* 是否专题 0:否 1:是 */
    private Integer isAuditNews; /* 是否发文审核 0:否 1:是 */

    private Integer showNewsNum;/* 首页显示新闻的条数 默认5条 */
    private Integer showNewsBrief;/* 首页新闻是否查询 新闻简介 新闻主体内容 0:否 1:是 */
    private Integer innerPageView;/* 内页展示方式 0:设计模板 1:自定义配置模板 */

    private String createId;
    private String createName;
    private String createTime;
    private String lastUpdateId;
    private String lastUpdateName;
    private String lastUpdateTime;

    public NewsProgram() {
    }

    public NewsProgram(String programId, String name, NewsProgram parentNewsProgram,
            List<NewsProgram> childNewsPrograms, String siteId, String linkUrl, Integer orderNo, String levelCode,
            String showfashion, Integer isPublic, String code, Integer indexPageProgram, Integer isZhuanti) {
        this.programId = programId;
        this.name = name;
        this.parentNewsProgram = parentNewsProgram;
        this.childNewsPrograms = childNewsPrograms;
        this.siteId = siteId;
        this.linkUrl = linkUrl;
        this.orderNo = orderNo;
        this.levelCode = levelCode;
        this.showfashion = showfashion;
        this.isPublic = isPublic;
        this.code = code;
        this.indexPageProgram = indexPageProgram;
        this.isZhuanti = isZhuanti;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public NewsProgram getParentNewsProgram() {
        return parentNewsProgram;
    }

    public void setParentNewsProgram(NewsProgram parentNewsProgram) {
        this.parentNewsProgram = parentNewsProgram;
    }

    public List<NewsProgram> getChildNewsPrograms() {
        return childNewsPrograms;
    }

    public void setChildNewsPrograms(ArrayList<NewsProgram> childNewsPrograms) {
        this.childNewsPrograms = childNewsPrograms;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getShowfashion() {
        return showfashion;
    }

    public void setShowfashion(String showfashion) {
        this.showfashion = showfashion;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIndexPageProgram() {
        return indexPageProgram;
    }

    public void setIndexPageProgram(Integer indexPageProgram) {
        this.indexPageProgram = indexPageProgram;
    }

    public Integer getIsZhuanti() {
        return isZhuanti;
    }

    public void setIsZhuanti(Integer isZhuanti) {
        this.isZhuanti = isZhuanti;
    }

    public Integer getIsAuditNews() {
        return isAuditNews;
    }

    public void setIsAuditNews(Integer isAuditNews) {
        this.isAuditNews = isAuditNews;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public String getLastUpdateName() {
        return lastUpdateName;
    }

    public void setLastUpdateName(String lastUpdateName) {
        this.lastUpdateName = lastUpdateName;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getShowNewsNum() {
        return showNewsNum;
    }

    public void setShowNewsNum(Integer showNewsNum) {
        this.showNewsNum = showNewsNum;
    }

    public Integer getShowNewsBrief() {
        return showNewsBrief;
    }

    public void setShowNewsBrief(Integer showNewsBrief) {
        this.showNewsBrief = showNewsBrief;
    }

    public Integer getInnerPageView() {
        return innerPageView;
    }

    public void setInnerPageView(Integer innerPageView) {
        this.innerPageView = innerPageView;
    }

}