package com.pigbaby.demo.beans;

import java.util.Date;

/**
 * news
 */

public class News {
    private String newsId;
    private String newsUrl;
    private String newsType;
    private String newsTitle;
    private Date publishDate;
    private Date topDate;

    public News() {
        this.setNewsId("test1");
        this.setNewsUrl("http://www.baidu.com");
        this.setNewsType("news");
        this.setNewsTitle("test1");
    }

    /**
     * @return the topDate
     */
    public Date getTopDate() {
        return topDate;
    }

    /**
     * @param topDate the topDate to set
     */
    public void setTopDate(Date topDate) {
        this.topDate = topDate;
    }

    /**
     * @return the publishDate
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * @param publishDate the publishDate to set
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * @return the newsTi
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * @param newsTitle the newsTit
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * @return the newsT
     */
    public String getNewsType() {
        return newsType;
    }

    /**
     * @param newsType the newsTy
     */
    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    /**
     * @return the news
     */
    public String getNewsUrl() {
        return newsUrl;
    }

    /**
     * @param newsUrl the newsU
     */
    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    /**
     * @return the new
     */
    public String getNewsId() {
        return newsId;
    }

    /**
     * @param newsId the news
     */
    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

}