package com.pigbaby.demo.beans;

import java.util.ArrayList;

/**
 * 新闻列表是一个存储新闻的对象。 有两个列表，一个是置顶栏目的新闻列，一个是按时间顺序排序的列。 NewsList
 */
public class NewsList {
    // 指定新闻列表
    private ArrayList<News> topNewsList;

    // 一般按照时间顺序的新闻列表
    private ArrayList<News> orderNewsList;

    public NewsList() {
        topNewsList = new ArrayList<News>();
        orderNewsList = new ArrayList<News>();
    }

    /**
     * @return the topNewsList
     */
    public ArrayList<News> getTopNewsList() {
        return topNewsList;
    }

    /**
     * @return the orderNewsList
     */
    public ArrayList<News> getOrderNewsList() {
        return orderNewsList;
    }

    /**
     * @param orderNewsList the orderNewsList to set
     */
    public void setOrderNewsList(ArrayList<News> orderNewsList) {
        this.orderNewsList = orderNewsList;
    }

    /**
     * @param topNewsList the topNewsList to set
     */
    public void setTopNewsList(ArrayList<News> topNewsList) {
        this.topNewsList = topNewsList;
    }

}