package com.pigbaby.demo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * MenuItem 定义一个菜单列表的菜单项
 */
public class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<MenuItem> subMenus;
    // 用于标识唯一的菜单
    private String menuId;
    // 父菜单项的标识
    private String parentMenuId;
    // 菜单名称
    private String menuName;
    // 菜单编码，备用，暂时不用
    private String menuCode;
    // 判断该菜单项是否是根结点
    private boolean initialFlag;
    // 父菜单项
    private MenuItem parentMenuItem;

    // 初始化一个菜单项
    public MenuItem() {
        this.setMenuId("");
        this.setMenuName("");
        this.initialFlag = false;
        this.setParentMenuId(null);
        this.setParentMenuId("");

        this.subMenus = new ArrayList<MenuItem>();
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
        if (this.isLeaf()) {
            return null;
        } else {
            // 沿着队列迭代遍历整棵树，根据id查找。
            for (int i = 0; i < this.getSubMenus().size(); i++) {
                MenuItem subItem = this.getSubMenus().get(i);
                MenuItem resultItem = subItem.findMenuItem(menuId);
                if (resultItem != null) {
                    return resultItem;
                }
            }
        }
        return null;
    }

    // 在指定位置插入一个菜单项，这个指定位置是指父节点的位置。该方法白话说明：在“新闻中心”（parentId）
    public boolean insertMenuItem(MenuItem menuItem, String parentId) {
        if (null == parentId || "" == parentId) {
            return false;
        } else {
            // 根据parentID
            MenuItem parentMenu = this.findMenuItem(parentId);
            if (null != parentMenu) {
                parentMenu.getSubMenus().add(menuItem);
                return true;
            } else {
                // 根据parentId没有找到匹配的菜单结点
                System.out.println("没有找到相应的子菜单");
                return false;
            }
        }
    }

    // 替换一个指定的MenuItem，主要是替换这个MenuItem的描述
    public boolean replaceMenuItem(String replaceName, String menuId) {
        if (null == menuId || "" == menuId) {
            return false;
        } else {
            MenuItem menuItem = this.findMenuItem(menuId);
            if (null != menuItem) {
                menuItem.setMenuName(replaceName);
            }
            return true;
        }
    }

    // 删除一个菜单项
    public boolean deleteMenuItem(String menuId) {
        MenuItem resultMenu = this.findMenuItem(menuId);
        if (resultMenu == null) {
            return false;
        } else {
            ArrayList<MenuItem> parentList = resultMenu.getParentMenuItem().getSubMenus();
            parentList.remove(resultMenu);
            return true;
        }
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
    public ArrayList<MenuItem> getSubMenus() {
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
    public void setSubMenus(ArrayList<MenuItem> subMenus) {
        this.subMenus = subMenus;
    }

    /**
     * @return the menuCode
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * @param menuCode the menuCode to set
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
}