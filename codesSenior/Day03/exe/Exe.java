package Day03.exe;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * ********概述：
 *
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

        TreeSet<Employee> set=new TreeSet<>(new Comparator<Employee>() {
            //使用泛型后的写法
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
            //未指明泛型时的写法
//            @Override
//            public int compare(Object o1, Object o2) {
//                if(o1 instanceof Day02.test8.Employee &&o2 instanceof Day02.test8.Employee){
//                   Employee e1=(Employee) o1,e2=(Employee) o2;
//                  MyDate b1=e1.getBirthday();
//                  MyDate b2=e2.getBirthday();
//                    int minusYear=b1.getYear()-b2.getYear();
//                    if(minusYear!=0)return minusYear;
//                    int minusMonth=b1.getMonth()-b2.getMonth();
//                    if(minusMonth!=0)return minusMonth;
//                    return b1.getDay()-b2.getDay();
//                }
//                throw new RuntimeException("数据不匹配");
//            }
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

