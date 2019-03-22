package com.pigbaby.demo.beans;

import java.io.Serializable;
import java.util.Hashtable;

import org.springframework.stereotype.Component;

/**
 * 这个类用于新闻的映射，所有的新闻将汇聚到这个类中。 该类由一个Hashtable组成。键值是新闻的栏目的Code。
 * 每个栏目下有两个列表，一个是置顶栏目的新闻列，一个是按时间顺序排序的列。 NewsMap
 */
@Component("newsmap")
public class NewsMapConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private Hashtable<String, NewsList> mainNewsTable;
    private Hashtable<String, NewsList> backNewsTable;

    public NewsMapConfig() {
        System.out.println("News map is ready");
    }

    /**
     * @return the backNewsTable
     */
    public Hashtable<String, NewsList> getBackNewsTable() {
        return backNewsTable;
    }

    /**
     * @param backNewsTable the backNewsTable to set
     */
    public void setBackNewsTable(Hashtable<String, NewsList> backNewsTable) {
        this.backNewsTable = backNewsTable;
    }

    /**
     * @return the mainNewsTable
     */
    public Hashtable<String, NewsList> getMainNewsTable() {
        return mainNewsTable;
    }

    /**
     * @param mainNewsTable the mainNewsTable to set
     */
    public void setMainNewsTable(Hashtable<String, NewsList> mainNewsTable) {
        this.mainNewsTable = mainNewsTable;
    }
}