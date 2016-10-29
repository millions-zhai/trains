package com.thoughtworks;


import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Administrator on 2016/10/26.
 * 图的数据结构实现，邻接表
 */
public class AdjacencyList implements GraphAction{

    public AdjacencyList(){
        this.nodeList=new LinkedList[maxNodes];
    }
    private LinkedList<Edge>[] nodeList;

    final int maxNodes=27;//定义最大值

    public class Edge {
        int node;
        int distance;

        Edge(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }


    @Override
    public void addEdge(int v1, int v2, int dist) throws GraphException{
        if(dist<1){
            throw  new GraphException("Invade distance");
        }
        Edge edge=new Edge(v2,dist);

        if(null==nodeList[v1]){
            nodeList[v1]=new LinkedList<Edge>();
        }
        nodeList[v1].add(edge);
    }

    @Override
    public int distance(int v1, int v2) throws GraphException{
        if(null==nodeList[v1]){
            throw new GraphException("No such edge");
        }
        ListIterator<Edge> iterators=nodeList[v1].listIterator();
        while(iterators.hasNext()){
            Edge e=iterators.next();
            if(e.node==v2){
                return e.distance;
            }
        }
        throw new GraphException("No such edge");
    }

    @Override
    public LinkedList getNerghbors(int v) {
        if(null==nodeList[v]){
            nodeList[v]=new LinkedList<Edge>();
        }

        return nodeList[v];
    }
}
