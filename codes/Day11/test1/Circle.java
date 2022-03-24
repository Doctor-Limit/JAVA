package Day11.test1;

import java.util.Objects;

public class Circle extends GemoetricObject{
    private double radius;
    public Circle(){
        //Ĭ�ϵ���super(),��ʱ�����б����Ѹ�ֵ
        radius=1.0;
    }
    public Circle(double radius){
        this.radius=radius;
    }
    public Circle(double radius,String color,double weight){
        super(color,weight);
        this.radius=radius;   //this(radius)��superֻ���ڷ�����һ�е���1��ֻ����һ�����ڣ�Ĭ��super��ǰ���ȵ���
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
        return this.radius==c.radius;//���ݰ뾶�����
    }
    return false;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }

}
