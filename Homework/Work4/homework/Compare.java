package Work4.homework;

import java.util.Scanner;

import static Work4.homework.test.Max;

public class Compare {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int max1=Max(2,3);
        double max2=Max(3.2,7.5);
        System.out.println("�������һ������");
        int a=scanner.nextInt();
        System.out.println("������ڶ�������");
        int b=scanner.nextInt();
        System.out.println("���������������");
        int c=scanner.nextInt();
        int max3=Max(a,b,c);
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);

    }
}
class test{
    public static int Max(int a,int b){
        return a>b?a:b;
    }
    public  static double Max(double a,double b){
        return a>b?a:b;
    }
    public  static int Max(int a,int b,int c){
        int d=a>b?a:b;
        return d>c?d:c;
    }
}