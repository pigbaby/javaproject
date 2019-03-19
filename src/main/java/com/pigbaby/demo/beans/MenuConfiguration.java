package com.pigbaby.demo.beans;

import java.io.Serializable;
import java.util.Hashtable;

import org.springframework.stereotype.Component;

/**
 * MenuConfiguration 这是一个用于网站前台的类，主要有两个个Hashtable组成。 该类控制了前台网站菜单的内容。
 */
@Component("mainmenu")
public class MenuConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;

    private Hashtable<String, MenuItem> mainConfiguration;
    private Hashtable<String, MenuItem> backConfiguration;

    // 思路：只初始化主要配置的hashtable,备份的hashtable由主配置clone而来。
    // 初始化该类的时候会去系统配置中查找是否存在已有之前的备份对象。如果有就获取备份的对象并读入内存。
    public MenuConfiguration() {
        // this.setMainConfiguration(new Hashtable < String, MenuItem > ());
        // this.getMainConfiguration().put("test", new MenuItem());
        System.out.println("main menu configuration is ready");
    }

    /**
     * @return the backConfiguration
     */
    public Hashtable<String, MenuItem> getBackConfiguration() {
        return backConfiguration;
    }

    /**
     * @param backConfiguration the backConfiguration to set
     */
    public void setBackConfiguration(Hashtable<String, MenuItem> backConfiguration) {
        this.backConfiguration = backConfiguration;
    }

    /**
     * @return the mainConfiguration
     */
    public Hashtable<String, MenuItem> getMainConfiguration() {
        return mainConfiguration;
    }

    /**
     * @param mainConfiguration the mainConfiguration to set
     */
    public void setMainConfiguration(Hashtable<String, MenuItem> mainConfiguration) {
        this.mainConfiguration = mainConfiguration;
    }

}