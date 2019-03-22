package com.pigbaby.demo.utils;

import com.pigbaby.demo.beans.News;

/**
 * 这个接口定义了对新闻路由对象NewsMap.java的操作。包括了 1. NewsMap的初始化。 2. NewsMap对象的备份。 3.
 * NewsMap对象中新闻的增删改查。 NewsUtils
 */
public interface NewsUtils {
    // NewsMap对象的初始化方法
    public boolean initNewsMap();

    // NewsMap对象的备份
    public boolean backNewsMap();

    // NewsMap对象的恢复
    public boolean restoreNewsMap();

    // 增加一条新闻
    public boolean insertNews(News news);

    // 伸出一条新闻
    public boolean deleteNews(News news);

    // 查找一条新闻
    public boolean findNews(String newsID, String newsType);
}