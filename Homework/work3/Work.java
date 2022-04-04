package work3;

import java.util.concurrent.Callable;

public class Work {
    public static void printCircle(Circle c){
     System.out.println("圆的面积为"+c.findArea());
     System.out.println("圆的半径为："+c.getRadius());
    }

    public static void main(String[] args) {
     Circle c1=new Circle(2.5);
     Circle c2=new Circle();
     c2.setRadius(3.9);
     Circle c3=new Circle(6.2);
     Circle c4=new Circle(4.6);

     printCircle(c1);
     printCircle(c2);
     printCircle(c3);
     System.out.println("圆的个数为："+Circle.getNumberOfObjects());
    }
}
