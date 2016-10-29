import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Administrator on 2016/10/26.
 */
public class CommonTest {

    @Test
    public void test(){
        System.out.println(tr('A'));
    }
    private int tr(char v) {
        return Character.getNumericValue(v) - 10;
    }

    @Test
    public void test2(){
        String s="AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        String[] ss=s.split("[\\s,][\\s]");
        for(int i=0;i<ss.length;i++){
            System.out.println(ss[i]);
        }

    }

    @Test
    public void test03(){
        LinkedList[] linkedLists=new LinkedList[27];

        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        Iterator l=linkedList.listIterator();
        while (l.hasNext()){
            System.out.println(l.next());
        }

        Integer first= linkedList.removeFirst();
        System.out.println(first);

        Iterator lt=linkedList.listIterator();
        while (lt.hasNext()){
            System.out.println(lt.next());
        }
    }
}
