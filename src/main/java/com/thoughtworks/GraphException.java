package com.thoughtworks;

/**
 * Created by Administrator on 2016/10/26.
 * 异常类
 */
public class GraphException extends Exception{
    String errMsg;
    public GraphException(){this.errMsg = "not set err msg";}
    public GraphException(String errMsg){
        this.errMsg=errMsg;
    }
    public String errMsg(){
        return this.errMsg;
    }
}
