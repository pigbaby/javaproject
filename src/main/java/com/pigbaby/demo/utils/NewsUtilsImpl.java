package com.pigbaby.demo.utils;

import javax.annotation.PostConstruct;

import com.pigbaby.demo.beans.News;
import com.pigbaby.demo.beans.NewsMapConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * NewsUtilsImpl
 */
@Service
public class NewsUtilsImpl implements NewsUtils {
    // 绑定Spring已经初始画的新闻路由NewsMap对象
    @Autowired(required = false)
    private NewsMapConfig newsMap;

    public NewsUtilsImpl() {
        System.out.println("The news map is ready!");
    }

    @Override
    // 对象初始化后立即运行。对新闻的Map进行初始化。
    @PostConstruct
    public boolean initNewsMap() {

        System.out.println("The news map is running!");
        return false;
    }

    /**
     * @return the newsMap
     */
    public NewsMapConfig getNewsMapConfig() {
        return newsMap;
    }

    /**
     * @param newsMap the newsMap to set
     */
    public void setNewsMap(NewsMapConfig newsMapConfig) {
        this.newsMap = newsMapConfig;
    }

    @Override
    public boolean backNewsMap() {
        return false;
    }

    @Override
    public boolean restoreNewsMap() {
        return false;
    }

    @Override
    public boolean insertNews(News news) {
        return false;
    }

    @Override
    public boolean deleteNews(News news) {
        return false;
    }

    @Override
    public boolean findNews(String newsID, String newsType) {
        return false;
    }

}