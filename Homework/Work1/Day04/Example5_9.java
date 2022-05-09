package Work1.Day04;

/**
 * ********概述：
 */
class C{
    final double PI=3.1415926;
    public double getArea(final double r){
        return r*r*PI;
    }
    public final void speak(){
        System.out.println("您好，How is everything here?");
    }

}
public class Example5_9 {
    public static void main(String[] args) {
        C c=new C();
        System.out.println("面积："+c.getArea(100));
        c.speak();
    }
}
