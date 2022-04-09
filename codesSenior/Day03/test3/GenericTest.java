package Day03.test3;

import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ********概述：
 * 1、泛型在继承方面的体现
 *
 *
 * 2、通配符的使用
 *
 *
 */
public class GenericTest {

    /*
    虽然类A是类B的父类，但G<A>、G<B>间不具备子父类关系，二者为并列关系
       类A是类B的父类,A<M>、B<M>具备子父类关系，二者可强转赋值
     */
    @Test
    public void test1(){
        Object obj=null;
        String str=null;
        obj=str;//子类也是父类的一部分

        //此时list1与list2无子父类关系
        List<Object> list1=null;
        List<String> list2=null;
       // list1=list2;

        ArrayList<String> list3=null;
        List<String> list4=null;
        AbstractList<String> list5=null;

    }
    /*
    通配符的使用：?
    类A是类B的父类，G<A>、G<B>没有关系，二者共同父类时G<?>
     */
    @Test
    public void test2(){
      List<Object> list1=null;
      List<String> list2=null;
      List<?> list3=null;

     // print(list1);
//      print(list3);
//      print(list2);

      List<String> list=new ArrayList<>();
      list.add("AA");
      list.add("BBB");
      list3=list;
      //对于List<?>就不能向其内部添加数据,null除外
        //list3.add(3);
        list3.add(null);

        //获取
        Object o=list3.get(0);
        System.out.println(o);

    }
    public void print(List<?> list){
        Iterator<?> iterator=list.iterator();
        while (iterator.hasNext()){
            Object obj=iterator.next();
            System.out.println(obj);
        }

    }

    /*
     有限制条件的通配符的使用
     ?==(负无穷，正无穷)--》最子类~最父类
  <=    ? extends A:==(负无穷，A)--》最子类~A类  仅能添加最子类对象
  >=    ? super A:==(A，正无穷)--》A类~最父类    能添加A类及A子类的对象
     T extends A ==>T<=A(作为A或其子类)
     T super   A ==>T>=A(作为A或其父类)

     */
    @Test
    public void test3(){
      List<? extends Person> list=null;
      List<? super Person> list1=null;

      List<Student> list2=null;
      List<Person> list3=null;
      List<Object> list4=null;

      list=list2;
      list=list3;
      //list=list4;

       list1=list3;
       list1=list4;
     //list1=list2;



    }


}
