/**
 * 经过对现有系统分析，发现现有系统已经可以产生符合要求的Menu的JSon代码。所以采用以下方式： 
 * 1. 后台系统负责栏目的编辑，授权，保存。 
 * 2. 前台系统负责获取到后台系统传过来的菜单的Json字符串。
 * 3. 菜单Json字符串是一个自嵌套的结构。可以让前台页面直接使用。
 */
package com.pigbaby.demo.beans;

import java.io.Serializable;
import java.util.Hashtable;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * AppMenuConfig
 */
@Component("appmenuconfig")
public class AppMenuConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    private Hashtable<String, String> mainMenuConfig;
    private Hashtable<String, String> backMenuConfig;

    public AppMenuConfig() {
        mainMenuConfig = new Hashtable<String, String>();
        System.out.println("The menu bean is created and the ID is :" + this.hashCode());
    }

    @PreDestroy
    public void clean() {
        System.out.println("The menu is closing");
    }

    /**
     * @return the mainMenuConfig
     */
    public Hashtable<String, String> getMainMenuConfig() {
        return mainMenuConfig;
    }

    /**
     * @return the backMenuConfig
     */
    public Hashtable<String, String> getBackMenuConfig() {
        return backMenuConfig;
    }

    /**
     * @param backMenuConfig the backMenuConfig to set
     */
    public void setBackMenuConfig(Hashtable<String, String> backMenuConfig) {
        this.backMenuConfig = backMenuConfig;
    }

    /**
     * @param mainMenuConfig the mainMenuConfig to set
     */
    public void setMainMenuConfig(Hashtable<String, String> mainMenuConfig) {
        this.mainMenuConfig = mainMenuConfig;
    }

}