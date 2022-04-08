package Day02.test9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ********概述：
 *
 */
public class ListTest {
    public static List duplicateList(List list){

        HashSet set=new HashSet();
        set.addAll(list);
        return new ArrayList(set);

    }

    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(2));
        list.add(Integer.valueOf(2));
        list.add(Integer.valueOf(4));
        list.add(Integer.valueOf(4));
        List list1=duplicateList(list);
        for(Object integer :list1){
            System.out.println(integer);
        }

    }
}
