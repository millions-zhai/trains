package com.thoughtworks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2016/10/27.
 */
public class MyTrain {

    public static void main(String args[])
    {
        String filename;
        TrainMap trainMap;
        try {
            filename = args[0];
            trainMap = new TrainMap(getFileInputStream(filename));
        } catch(Exception e)	{
            System.out.println("Usage: java Trains <filename>");
            return;
        }

        System.out.println("Output #1: " + trainMap.routeDistance("ABC"));
        System.out.println("Output #2: " + trainMap.routeDistance("AD"));
        System.out.println("Output #3: " + trainMap.routeDistance("ADC"));
        System.out.println("Output #4: " + trainMap.routeDistance("AEBCD"));
        System.out.println("Output #5: " + trainMap.routeDistance("AED"));

        System.out.println("Output #6: " + trainMap.countRouteByMaxStop('C','C',3));
        System.out.println("Output #7: " + trainMap.countRouteByExactStop('A','C',4));
        System.out.println("Output #8: " + trainMap.shortestRouteDistance('A','C'));
        System.out.println("Output #9: " + trainMap.shortestRouteDistance('B','B'));
        System.out.println("Output #10: " + trainMap.countRouteLimitDistance('C','C',29));
    }

    private static FileInputStream getFileInputStream(String name) {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(name);
        } catch (FileNotFoundException e) {
            System.err.println(name + ": File not found");
            System.exit(1);
        }
        return stream;
    }

}
