package com.pigbaby.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.pigbaby.demo.beans.AppMenuConfig;
import com.pigbaby.demo.beans.MenuConfigBean;
import com.pigbaby.demo.beans.MenuItem;
import com.pigbaby.demo.beans.testbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

/**
 * InitializeMenuImpl
 */
@Service
public class InitializeMenuImpl implements InitializeMenu {
    // 从系统配置文件applicatioin.properties
    @Autowired(required = false)
    private MenuConfigBean configBean;
    // 获取系统初始化的菜单项
    @Autowired(required = false)
    private AppMenuConfig appMenuConfig;

    // // 获取系统初始化的菜单项
    // @Autowired(required = false)
    // private MenuConfiguration menuConfig;

    public InitializeMenuImpl() {

    }

    /**
     * @return the appMenuConfig
     */
    public AppMenuConfig getAppMenuConfig() {
        return appMenuConfig;
    }

    /**
     * @param appMenuConfig the appMenuConfig to set
     */
    public void setAppMenuConfig(AppMenuConfig appMenuConfig) {
        this.appMenuConfig = appMenuConfig;
    }

    @Override
    public boolean initialize(String type) {
        return false;
    }

    /**
     * Spring启动以后需要运行该方法来导入菜单 整个菜单配置的生成会有两个时间点：
     * 第一个是整个网站系统初始化的时候，所有网站菜单需要在后台配置好以后传给前台，作为前台菜单的参考。
     * 第二个是在前台系统重新启动的时候，需要到指定的目录下查找是否已有已经保存的java类，如果有就作为备份直接导入。
     */
    @Override
    @PostConstruct
    public boolean initialize() {
        // 查找是否存在已有的配置的Java对象文件
        try {
            File backFile = ResourceUtils.getFile("classpath:" + configBean.getMainMenuBackPath());

            if (!backFile.exists()) {
                // System.out.println("the configuration path is: " + backFile.getPath());
                // this.backMenuConfig(backFile);
                // 如果备份文档村则直接从备份的java对象中获取到树状结构的配置，并且复制到ManuConfiguration对象中
                restoreMenuConfig(backFile);
                // System.out.println("The manuconfiguration is binded: " +
                // menuConfig.getMainConfiguration().get("test"));
            } else {
                // 如果文件不存在，则需要从后台系统中获取。
                String serverMenu = SourceFile.getHtml(
                        "http://192.168.105.108:8080/front_server/newsProgram/listexForNewsProgramListAction!listex.action");
                // 将该字符串插入进菜单配置的Hashmap中。
                appMenuConfig.getMainMenuConfig().put("main", serverMenu);
                // System.out.println(appMenuConfig.getMainMenuConfig().get("main"));
                // System.out.println("New main menu is ready");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    // 该方法将一个菜单的java对象通过序列化备份到指定的位置
    @Override
    public boolean backMenuConfig(File file) {
        if (!file.exists()) {
            // 判断文件路径是否存在，如果不存在则返回错误。
            return false;
        } else {
            FileOutputStream fileOS;
            ObjectOutputStream objOS;
            // 写入到指定文件中。
            try {
                fileOS = new FileOutputStream(file);
                objOS = new ObjectOutputStream(fileOS);
                // System.out.println("Is writing");

                System.out.println(file.getParent());
                objOS.writeObject(appMenuConfig.getMainMenuConfig());
                // System.out.println("Done!!!!!!!");
                objOS.close();
                fileOS.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean restoreMenuConfig(File file) {
        if (!file.exists()) {
            // 判断文件路径是否存在，如果不存在则返回错误。
            return false;
        } else {
            FileInputStream fileIS;
            ObjectInputStream objIS;
            // 写入到指定文件中。
            try {
                fileIS = new FileInputStream(file);
                objIS = new ObjectInputStream(fileIS);
                Hashtable<String, String> backTable = (Hashtable<String, String>) objIS.readObject();
                this.appMenuConfig.setMainMenuConfig(backTable);
                // System.out.println("Done!!!!!!!");
                objIS.close();
                fileIS.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @Override
    public boolean refreshMenuConfig() {
        return false;
    }

    @Override
    public boolean refreshMenuItem(MenuItem menuItem) {
        return false;
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
    public void setConfigBean(MenuConfigBean configBean) {
        this.configBean = configBean;
    }

}