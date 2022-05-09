package Work1.Day03.Example4_25;

/**
 * ********¸ÅÊö£º
 */
public class Circular {
    Circle bottom;
    double height;
    public Circular(Circle c,double h){
        bottom=c;
        height=h;
    }
    public double getVolme(){
        return bottom.getArea()*height/3.0;
    }
}
