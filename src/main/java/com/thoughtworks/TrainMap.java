package com.thoughtworks;

import java.io.*;

/**
 * Created by Administrator on 2016/10/26.
 * 在基础上构造我们自己的图, 并实现需要的方法
 */
public class TrainMap extends Graph{

    private static String charToNum="0ABCDEFGHIJKLMNOPQ";

    public TrainMap(String str){
        createMap(str);
    }

    public TrainMap(InputStream inputStream) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line,data="";
        while (null != (line = reader.readLine())) {
            data += line;
        }
        createMap(data);
    }


    public void createMap(String data) {
        //TODO
        String[] edge=data.split("[\\s,][\\s]*");
        for(int i=0;i<edge.length;i++){
            int distance=Integer.parseInt(edge[i].substring(2));
            try {
                addEdge(charToNum.indexOf(edge[i].charAt(0)) , charToNum.indexOf(edge[i].charAt(1)) , distance);
            }catch (GraphException e){
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * 适合问题 1-5 返回对应的路径距离
     * @param route  字符串路径
     * @return
     */
    public Object routeDistance(String route){
        int rd=0;

        try{
            for(int i=0;i<route.length()-1;) {
                rd += distance(charToNum.indexOf(route.charAt(i)) , charToNum.indexOf(route.charAt(++i)));
            }
        }catch (GraphException e){
            return e.errMsg;
        }
        return rd;
    }

    /**
     * 问题8-9 求最短距离
     */
    public Object shortestRouteDistance(char start,char end){
        int srd=0;

        try{
            srd=shortestRouteDistance(charToNum.indexOf(start),charToNum.indexOf(end));
        }catch (GraphException e){
            return e.errMsg;
        }
        return srd;
    }


    /**
     * 问题10 ，求限制距离的情况下 的路径条数
     */
    public Object countRouteLimitDistance(char start,char end,int maxDistance){
        int crld=0;

        try{
            crld=countRouteLimitDistance(charToNum.indexOf(start),charToNum.indexOf(end),maxDistance);
        }catch (GraphException e){
            return e.getMessage();
        }
        return crld;
    }

    /**
     * 问题6，最大停止的次数
     */
    public Object countRouteByMaxStop(char start,char end,int maxStop){
        int crms=0;
        try{
            crms=countRouteByMaxStop(charToNum.indexOf(start),charToNum.indexOf(end),maxStop).length;
        }catch (GraphException e){
            return e.errMsg;
        }
        return crms;
    }

    /**
     * 问题7，指定停止的次数
     */
    public Object countRouteByExactStop(char start,char end,int exactStop){
        int[] routes;

        try{
            routes=countRouteByMaxStop(charToNum.indexOf(start),charToNum.indexOf(end),exactStop);
        }catch (GraphException e){
            return e.errMsg;
        }
        int count=0;
        for(int i=0;i<routes.length;i++){
            if(routes[i]==exactStop){
                count++;
            }
        }
        return count;
    }
}
