package com.pigbaby.demo.beans; 

import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.Serializable; 
import java.util.Hashtable; 

import javax.annotation.PostConstruct; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component; 
import org.springframework.util.ResourceUtils; 

/**
 * MenuConfiguration 这是一个用于网站前台的类，主要有两个个Hashtable组成。 该类控制了前台网站菜单的内容。
 */
@Component("mainmenu")
public class MenuConfiguration implements Serializable {

    private static final long serialVersionUID = 1L; 

    private Hashtable < String, MenuItem > mainConfiguration; 
    private Hashtable < String, MenuItem > backConfiguration; 

    private MenuConfigBean configBean; 

    // 思路：只初始化主要配置的hashtable,备份的hashtable由主配置clone而来。
    // 初始化该类的时候会去系统配置中查找是否存在已有之前的备份对象。如果有就获取备份的对象并读入内存。
    public MenuConfiguration() {
        this.mainConfiguration = new Hashtable < String, MenuItem > (); 
        System.out.println("main menu configuration is ready"); 
    }

    //
    @PostConstruct
    public boolean postMenuConstruct() {
        backMenuConfig(); 
        return true; 
    }

    /**
     * 整个菜单配置的生成会有两个时间点： 第一个是整个网站系统初始化的时候，所有网站菜单需要在后台配置好以后传给前台，作为前台菜单的参考。
     * 第二个是在前台系统重新启动的时候，需要到指定的目录下查找是否已有已经保存的java类，如果有就作为备份直接导入。
     */

    // 整个配置文件的备份，将整个Java对象备份到项目文件夹下。默认情况下是保存在系统的classpath文件夹下
    public boolean backMenuConfig() {
        // 查找是否存在已有的配置的Java对象文件
        try {
            File backFile = ResourceUtils.getFile("classpath:" + configBean.getMainMenuBackPath()); 

            if (backFile.exists()) {
                // System.out.println(backFile.getPath());
                // System.out.println("the configuration path is: " +
                // configBean.getMainMenuBackPath());
                System.out.println("the configuration path is: " + backFile.getPath()); 
            }else {
                System.out.println("Can not find the file"); 
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace(); 
        }
        return true; 
    }

    // 整个配置文件备份的恢复。
    public boolean restoreMenuConfig() {
        return true; 
    }

    /**
     * @return the configBean
     */
    public MenuConfigBean getConfigBean() {
        return configBean; 
    }

    /**
     * @param configBean the configBean to set
     */
    @Autowired(required = false)
    public void setConfigBean(MenuConfigBean configBean) {
        this.configBean = configBean; 
        // System.out.println("Menu Configuration Bean is Ready");
    }

}