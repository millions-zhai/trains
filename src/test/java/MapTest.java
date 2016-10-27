import com.thoughtworks.TrainMap;
import junit.framework.TestCase;


/**
 * Created by Administrator on 2016/10/27.
 */
public class MapTest extends TestCase{


    public void test1(){
        TrainMap trainMap=new TrainMap("AB2, BA3, BD5, BE7, DB11, EB13, CE17, EC19, DE23, ED29, CF31, " +
                "FC37, EF41, FE43, FA53, AF59, DA61, AD67, EA71, AE73");

        System.out.println("Output #1: " + trainMap.routeDistance("ABC"));
        System.out.println("Output #2: " + trainMap.routeDistance("AD"));
        System.out.println("Output #3: " + trainMap.routeDistance("ADC"));
        System.out.println("Output #4: " + trainMap.routeDistance("AEBCD"));
        System.out.println("Output #5: " + trainMap.routeDistance("AED"));
    }

    public void test2(){
        TrainMap trainMap=new TrainMap("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
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

}
