package com.pigbaby.demo.utils;

/**
 * InitializeMenu 定义一个操作菜单的接口。系统中存在的菜单有两种，一种是页面的菜单，第二种是专题菜单。 在系统初始化的时候进行菜单初始化。
 */
public interface InitializeMenu {
    // 根据不同类型来初始化不同的菜单
    public boolean initialize(String type);

    // 菜单初始化，前台从后台提供的Restful接口中获取菜单信息。
    public boolean initialize();
}