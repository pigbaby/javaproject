package com.pigbaby.demo.webcomponents;

import com.pigbaby.demo.beans.AppMenuConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * MenuServlet
 */
@RestController
public class MenuServlet {
    // 通过@Autowired来绑定已经在spring中初始化的bean。
    @Autowired(required = false)
    private AppMenuConfig appMenuConfig;

    @RequestMapping(value = "/mainmenu", method = RequestMethod.GET)
    public String getMainMenu() {
        System.out.println("The ID of application menu configuration is :" + appMenuConfig.hashCode());
        return appMenuConfig.getMainMenuConfig().get("main");
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
}