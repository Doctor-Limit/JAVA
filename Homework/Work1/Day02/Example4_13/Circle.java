package Work1.Day02.Example4_13;

public class Circle {
    double radius,area;
    void setRadius(double radius){
        this.radius=radius;
    }
    public double getArea() {
        area=3.14*radius*radius;
        return area;
    }
}
