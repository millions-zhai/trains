package com.thoughtworks;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2016/10/26.
 * 继承邻接表对象，实现图的功能
 *
 *
 */
public class Graph extends AdjacencyList {

    /**
     * 内部类，用于统计各个节点的状态
     */
    public class Status{
        int node;
        int distance;
        boolean done;

        Status(int node,int distance){ //求所有路径
            this.node=node;
            this.distance=distance;
        }

        Status(int distance,boolean done){ //求最短距离
            this.distance=distance;
            this.done=done;
        }
    }

    /**
     * 求两个节点之间的路径, 使用迪杰卡斯拉算法
     * @param start  起始点
     * @param end    终止点
     * @return
     * @throws GraphException
     */
    public int shortestRouteDistance(int start,int end) throws GraphException{
        Status[] status=new Status[maxNodes];
        status[start] = new Status(0,false);
        int current=start;

        do {

            LinkedList neighborList = getNerghbors(current);
            ListIterator<Edge> iterator = neighborList.listIterator();
            while (iterator.hasNext()) {              //遍历每一个neighbor
                Edge neighbor = iterator.next();
                int thoughtCurrentDistance = status[current].distance + neighbor.distance;

                if (null == status[neighbor.node]) { //添加新的节点至状态列表
                    status[neighbor.node] = new Status(thoughtCurrentDistance, false);
                } else if (status[neighbor.node].distance > thoughtCurrentDistance) { //记录最新的最短距离
                    status[neighbor.node].distance = thoughtCurrentDistance;
                }

            }

            status[current].done=true; //当前这个节点我们已近找到最近的的路径

            if(current==end){
                status[current]=null;
            }
            //根据状态信息集合 获取最近的下一个节点
            current=getClosest(status);
            if(current==0){
                throw new GraphException("no such path");
            }

        }while (current!=end);

        return status[end].distance;
    }

    /**
     * 根据状态集合获取最近距离的节点
     * @param statuses    状态集合
     * @return  返回节点的索引
     */
    private int getClosest(Status[] statuses){
        int smallestIndex=0;
        int smallestDistance=0;
        for(int i=1;i<maxNodes;i++){

            if(null==statuses[i]){ //未被初始化的
                continue;
            }
            if(false==statuses[i].done){  //候选节点，已经被初始化但是还没有在最最小路径中
                //如果是第一个  或是 比上一个小的距离
                if(0==smallestIndex || smallestDistance>statuses[i].distance){
                    smallestDistance=statuses[i].distance;
                    smallestIndex=i;
                }
            }
        }
        return smallestIndex;
    }

    /**
     * 统计指定的起终点路径条数
     * @param start          开始节点
     * @param end            终止节点
     * @param maxDistance    最大距离
     * @return               路径总数
     */
    public int countRouteLimitDistance(int start,int end,int maxDistance) throws GraphException {
       return countPaths(start,end,maxDistance,false).length;
    }

    /**
     * 最大停止次数内的路径
     * @param start
     * @param end
     * @param stops
     * @return
     * @throws GraphException
     */
    public int[] countRouteByMaxStop(int start,int end,int stops) throws GraphException{
        return countPaths(start,end,stops,true);
    }

    /**
     * 统计路径条数
     * @param start
     * @param end
     * @param maxDistance
     * @param countHops
     * @return
     * @throws GraphException
     */
    private int [] countPaths(int start, int end, int maxDistance, boolean countHops)
            throws GraphException
    {
        LinkedList queue = new LinkedList();
        LinkedList distances = new LinkedList();

        Status current = new Status(start, 0);
        while(true){
            LinkedList neighborList = getNerghbors(current.node);	//获取临近节点
            ListIterator i = neighborList.listIterator(0);
            while(i.hasNext())                                 //遍历邻居节点
            {
                Edge neighbor = (Edge) i.next();

                int distanceFromStart = current.distance;
                if(countHops)	{
                    distanceFromStart += 1;
                }else{
                    distanceFromStart += neighbor.distance;
                }

                if( distanceFromStart <= maxDistance)		//如果在最大距离范围内，添加近队列
                    queue.add( new Status( neighbor.node, distanceFromStart) );
            }

            try {
                current = (Status) queue.removeFirst();	//从队列前取出一个继续需找，如果队列中是空，就结束
            } catch (NoSuchElementException e) {
                break;
            }

            if(current.node == end ) {                    //发现了一条路径，记录下来
                distances.add(new Integer(current.distance));
            }
        }

        return listToArray(distances);
    }

    private int [] listToArray(LinkedList list)
    {
        int [] array = new int[list.size()];		//create return list
        int i;
        for( i = 0; !list.isEmpty(); i++)
            array[i] = ((Integer)list.removeFirst()).intValue();
        return array;
    }
}