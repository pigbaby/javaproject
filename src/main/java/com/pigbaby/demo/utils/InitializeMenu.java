package com.pigbaby.demo.utils; 

import java.io.File; 

import com.pigbaby.demo.beans.MenuItem; 

/**
 * InitializeMenu 定义一个操作菜单的接口。系统中存在的菜单有两种，一种是页面的菜单，第二种是专题菜单。 在系统初始化的时候进行菜单初始化。
 */
public interface InitializeMenu {
    // 根据不同类型来初始化不同的菜单
    public boolean initialize(String type); 

    // 菜单初始化，前台从后台提供的Restful接口中获取菜单信息。
    public boolean initialize(); 

    // 备份菜单栏配置java对象
    public boolean backMenuConfig(File file); 

    // 恢复已经备份的菜单栏配置java对象。
    public boolean restoreMenuConfig(File file); 

    // 更新整个菜单栏
    public boolean refreshMenuConfig(); 

    // 更新置顶的菜单栏
    public boolean refreshMenuItem(MenuItem menuItem); 
}