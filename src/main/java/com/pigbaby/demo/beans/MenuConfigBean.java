package com.pigbaby.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ConfigurationBean 该类是用于主菜单配置的Bean。
 * 该Bean会从application.properties配置文件中获取参数，作为MenuConfiguration.java的配置参数。
 */
@Component("menuconfig")
public class MenuConfigBean {
    // 页面主菜单的备份路径，这里定义的是相对路径，在classpath下。
    @Value("${main.menu.path}")
    private String mainMenuBackPath;

    public MenuConfigBean() {

    }

    /**
     * @return the mainMenuBackPath
     */
    public String getMainMenuBackPath() {
        return mainMenuBackPath;
    }

    /**
     * @param mainMenuBackPath the mainMenuBackPath to set
     */
    public void setMainMenuBackPath(String mainMenuBackPath) {
        this.mainMenuBackPath = mainMenuBackPath;
    }
}