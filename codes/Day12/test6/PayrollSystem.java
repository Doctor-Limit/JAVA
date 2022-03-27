package Day12.test6;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {

//        Scanner scanner=new Scanner(System.in);
//        System.out.println("请输入当月月份：");
//        int month=scanner.nextInt();

        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);//获取当前月份
        //System.out.println(month);//从零开始

        Employee[] emps=new Employee[2];//并不是Employee对象，而是Employee类的数组，数组元素暂时声明为抽象类
        emps[0]=new SalariedEmployee("张三",1001,new MyDate(1943,4,19),10000);
        emps[1]=new HourlyEmployee("李四",1002,new MyDate(2001,5,23),60,240);

        for(int i=0;i< emps.length;i++){
            System.out.println(emps[i].toString());
            double salary=emps[i].earnings();
            if(month++==emps[i].getBirthday().getMonth()) {
                System.out.println("生日快乐，奖励100元");
                salary+=100;
            }
            System.out.println("月工资为："+salary);
        }
    }
}
