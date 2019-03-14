package com.pigbaby.demo.beans;

import java.util.Hashtable;

import org.springframework.stereotype.Component;

/**
 * RouterMap
 */
@Component("routerMap")
public class RouterMap {

    private Hashtable<String, News> routerTable;

    public RouterMap() {
        this.routerTable = new Hashtable<String, News>();
        routerTable.put("100", new News());
        System.out.println("Map is Initialed");
    }

    /**
     * @return the routerTable
     */
    public Hashtable<String, News> getRouterTable() {
        return routerTable;
    }

    /**
     * @param routerTable the routerTable to set
     */
    public void setRouterTable(Hashtable<String, News> routerTable) {
        this.routerTable = routerTable;
    }

    // 插入一条新闻
    public void insertNews(News news) {
        routerTable.put(news.getNewsId(), news);
        return;
    }

    // 查找一条新闻
    public News findNews(String newsId) {
        return routerTable.get(newsId);
    }

    public String toString() {
        return this.routerTable.toString();
    }
}