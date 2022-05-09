package Work1.Day04.Example5_1;

/**
 * ********概述：
 */
public class Example5_1 {
    public static void main(String[] args) {
        Student zhang=new Student();
        zhang.age=17;
        zhang.number=100101;
        zhang.showPeopleMess();
        zhang.tellNumber();
        int x=9,y=29;
        System.out.println("会做加法:");
        int result= zhang.add(x,y);
        System.out.println("x+y="+result);
        UniverStudent geng=new UniverStudent();
        geng.age=21;
        geng.number=6609;
        geng.showPeopleMess();
        geng.tellNumber();
        System.out.println("会做加法：");
        result= geng.add(x,y);
        System.out.println("x+y="+result);
        System.out.println("会做乘法：");
        result=geng.multi(x,y);
        System.out.println("x*y="+result);
    }
}
