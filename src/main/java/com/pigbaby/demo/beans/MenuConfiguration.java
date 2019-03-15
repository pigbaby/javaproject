package com.pigbaby.demo.beans; 

import java.io.Serializable; 
import java.util.Hashtable; 

import org.springframework.stereotype.Component; 

/**
 * MenuConfiguration 这是一个用于网站前台的类，主要有两个个Hashtable组成。 该类控制了前台网站菜单的内容。
 */
@Component("menuconfig")
public class MenuConfiguration implements Serializable {

    private static final long serialVersionUID = 1L; 

    private Hashtable < String, MenuItem > mainConfiguration; 
    private Hashtable < String, MenuItem > backConfiguration; 

    // 思路：只初始化主要配置的hashtable,备份的hashtable由主配置clone而来。
    public MenuConfiguration() {
        this.mainConfiguration = new Hashtable < String, MenuItem > (); 
    }

    /**
     * 整个菜单配置的生成会有两个时间点： 第一个是整个网站系统初始化的时候，所有网站菜单需要在后台配置好以后传给前台，作为前台菜单的参考。
     * 第二个是在前台系统重新启动的时候，需要到指定的目录下查找是否已有已经保存的java类，如果有就作为备份直接导入。
     */

    // 整个配置文件的备份，将整个Java对象备份到项目文件夹下。默认情况下是保存在系统的classpath文件夹下
    public boolean backMenuConfig() {
        // 查找是否存在已有的配置的Java对象文件
        ResourceUtils.getURL("classpath:").getPath(); 
        return true; 
    }

    // 整个配置文件备份的恢复。
    public boolean restoreMenuConfig() {
        return true; 
    }
}