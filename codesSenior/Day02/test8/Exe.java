package Day02.test8;


import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * ********概述：
 */
public class Exe {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(2001, 1, 3);
        MyDate date2 = new MyDate(2004, 3, 19);
        MyDate date3 = new MyDate(2000, 5, 13);
        Employee[] employees=new Employee[3];

        employees[0]=new Employee("Tom",25,date1);
        employees[1]=new Employee("Jack",32,date2);
        employees[2]=new Employee("Marry",27,date3);

        //Employee实现按name排序
//        Arrays.sort(employees, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if(o1 instanceof Employee&&o2 instanceof Employee){
//                    Employee e1=(Employee) o1,e2=(Employee) o2;
//                    return e1.compareTo(e2);
//                }
//                throw new RuntimeException("数据不匹配");
//            }
//        });
//        for(Object obj:employees){
//            System.out.println(obj);
//        }


        TreeSet set=new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee&&o2 instanceof Employee){
                    Employee e1=(Employee) o1,e2=(Employee) o2;
                    MyDate b1=e1.getBirthday();
                    MyDate b2=e2.getBirthday();
                    int minusYear=b1.getYear()-b2.getYear();
                    if(minusYear!=0)return minusYear;
                    int minusMonth=b1.getMonth()-b2.getMonth();
                    if(minusMonth!=0)return minusMonth;
                    return b1.getDay()-b2.getDay();
                }
                throw new RuntimeException("数据不匹配");
            }
        });
        set.add(employees[0]);
        set.add(employees[1]);
        set.add(employees[2]);
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
