package com.pigbaby.demo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * MenuItem 定义一个菜单列表的菜单项
 */
public class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<MenuItem> subMenus;
    // 用于标识唯一的菜单
    private String menuId;
    private String parentMenuId;
    private String menuName;
    private boolean initialFlag;
    private MenuItem parentMenuItem;

    // 初始化一个菜单项
    public MenuItem() {
        this.setMenuId("");
        this.setMenuName("");
        this.initialFlag = false;
        this.subMenus = new ArrayList<MenuItem>();
        this.setParentMenuId(null);
        this.setParentMenuId("");
    }

    // 插入一个节点到当前结点
    public void addChildMenu(MenuItem subMenuItem) {
        this.subMenus.add(subMenuItem);
    }

    // 判断当前结点是否为叶节点：没有子菜单
    public boolean isLeaf() {
        if (this.subMenus.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 返回从当前结点到初始节点的路径 如：首页/新闻中心/集团要闻
    public List<MenuItem> menuPath() {
        ArrayList<MenuItem> path = new ArrayList<MenuItem>();
        MenuItem currentMenuItem = this;
        path.add(currentMenuItem);
        while (!currentMenuItem.isInitialFlag()) {
            currentMenuItem = currentMenuItem.getParentMenuItem();
            path.add(currentMenuItem);
        }
        return path;
    }

    // 根据一个Id找到树种对应的菜单项
    public MenuItem findMenuItem(String menuId) {
        // 判断当前结点是否是要招的ID。
        if (this.getMenuId() == menuId) {
            return this;
        }
        // 判断当前结点下的子菜单是否为空。
        if (this.getSubMenus() == null || this.getSubMenus().isEmpty()) {
            return null;
        } else {

        }

    }

    // 在指定位置插入一个菜单项
    public boolean insertMenuItem(MenuItem MenuItem, String parentId) {
        if (null == parentId || "" == parentId) {
            return false;
        } else {

        }
        return true;
    }

    /**
     * @return the parentMenuId
     */
    public String getParentMenuId() {
        return parentMenuId;
    }

    /**
     * @param parentMenuId the parentMenuId to set
     */
    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    /**
     * @return the parentMenuItem
     */
    public MenuItem getParentMenuItem() {
        return parentMenuItem;
    }

    /**
     * @param parentMenuItem the parentMenuItem to set
     */
    public void setParentMenuItem(MenuItem parentMenuItem) {
        this.parentMenuItem = parentMenuItem;
    }

    /**
     * @return the subMenus
     */
    public List<MenuItem> getSubMenus() {
        return subMenus;
    }

    /**
     * @return the initialFlag
     */
    public boolean isInitialFlag() {
        return initialFlag;
    }

    /**
     * @param initialFlag the initialFlag to set
     */
    public void setInitialFlag(boolean initialFlag) {
        this.initialFlag = initialFlag;
    }

    /**
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return the menuId
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId the menuId to set
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * @param subMenus the subMenus to set
     */
    public void setSubMenus(List<MenuItem> subMenus) {
        this.subMenus = subMenus;
    }
}