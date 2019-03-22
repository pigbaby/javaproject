package com.pigbaby.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 这是一个配置类，主要用于新闻列表，以及新闻路由类的配置。 NewsConfigBean
 */
@Component("newsconfig")
public class NewsConfigBean {
    @Value("main.news.path")
    private String mainNewsBackPath;

    public NewsConfigBean() {

    }

}