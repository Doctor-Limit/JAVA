package Day11.test1;

import java.util.Objects;

public class Circle extends GemoetricObject{
    private double radius;
    public Circle(){
        //默认调用super(),此时父类中变量已赋值
        radius=1.0;
    }
    public Circle(double radius){
        this.radius=radius;
    }
    public Circle(double radius,String color,double weight){
        super(color,weight);
        this.radius=radius;   //this(radius)与super只能在方法第一行调用1且只能有一个存在，默认super在前面先调用
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public double findArea(){
        return 3.14*radius*radius;
    }

    @Override
    public boolean equals(Object obj) {
    if(this==obj)return true;
    if(obj instanceof Circle){
        Circle c=(Circle) obj;
        return this.radius==c.radius;//根据半径来辨别
    }
    return false;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }

}
