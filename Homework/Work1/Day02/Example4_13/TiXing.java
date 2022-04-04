package Work1.Day02.Example4_13;

public class TiXing {
    double above,bottom,height;
    TiXing(double a,double b,double h){
        this.above=a;
        this.bottom=b;this.height=h;
    }
    double getArea(){
        return (above+bottom)*height/2;
    }
}
