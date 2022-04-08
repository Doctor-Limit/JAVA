package Day02.test10;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ********概述：
 */
public class Exe {

    @Test
    public void test1(){
        Scanner scanner=new Scanner(System.in);
        List list=new ArrayList();
        int result=scanner.nextInt();
        while (list.size()<10){
            list.add(result);
            result=scanner.nextInt();
        }
        Collections.reverse(list);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
               if(o1 instanceof Integer&&o2 instanceof Integer){
                  Integer i1=(Integer) o1,i2=(Integer) o2;
                  return -Integer.compare(i1,i2);
               }
               throw new RuntimeException("类型不匹配");
            }
        });
        System.out.println(list);
    }

    @Test
    public void test2(){
         Student[] students=new Student[5];
         students[0]=new Student("Tom",98,1);
         students[1]=new Student("Jack",96,2);
         students[2]=new Student("Marry",78,3);
         students[3]=new Student("Alice",89,5);
         students[4]=new Student("Petter",90,4);
         List list=Arrays.asList(students[0],students[1],students[2],students[3],students[4]);
         Collections.sort(list, new Comparator() {
             @Override
             public int compare(Object o1, Object o2) {
                 if(o1 instanceof Student&&o2 instanceof Student){
                     Student s1=(Student) o1,s2=(Student) o2;
                     return s2.getScore()-s1.getScore();
                 }
                 throw new RuntimeException("数据类型不匹配");
             }
         });
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test3(){

    }

    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List list=new ArrayList();
        int result=scanner.nextInt();
        while (list.size()<10){
            list.add(result);
            result=scanner.nextInt();
        }
        Collections.reverse(list);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Integer&&o2 instanceof Integer){
                    Integer i1=(Integer) o1,i2=(Integer) o2;
                    return -Integer.compare(i1,i2);
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        System.out.println(list);
    }

}
