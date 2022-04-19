package work3.test1;

public class Circle {
private double radius;
static int numberOfObjects;
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return Math.PI*radius*radius;
    }
    public Circle(){
        numberOfObjects++;
    }
    public Circle(double radius){
        this.radius=radius;
        numberOfObjects++;
    }
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }
}
