package Day12.test6;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {

//        Scanner scanner=new Scanner(System.in);
//        System.out.println("�����뵱���·ݣ�");
//        int month=scanner.nextInt();

        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);//��ȡ��ǰ�·�
        //System.out.println(month);//���㿪ʼ

        Employee[] emps=new Employee[2];//������Employee���󣬶���Employee������飬����Ԫ����ʱ����Ϊ������
        emps[0]=new SalariedEmployee("����",1001,new MyDate(1943,4,19),10000);
        emps[1]=new HourlyEmployee("����",1002,new MyDate(2001,5,23),60,240);

        for(int i=0;i< emps.length;i++){
            System.out.println(emps[i].toString());
            double salary=emps[i].earnings();
            if(month++==emps[i].getBirthday().getMonth()) {
                System.out.println("���տ��֣�����100Ԫ");
                salary+=100;
            }
            System.out.println("�¹���Ϊ��"+salary);
        }
    }
}
