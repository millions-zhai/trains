package com.thoughtworks;

import java.util.LinkedList;

/**
 * Created by Administrator on 2016/10/26.
 * 定义图的接口
 */
public interface GraphAction {
    /**
     * 添加边
     */
    void addEdge(int v1,int v2,int dist) throws GraphException;
    /**
     * 返回两个节点的距离
     */
    int distance(int v1,int v2) throws GraphException;


    LinkedList getNerghbors(int v) throws GraphException;
}
