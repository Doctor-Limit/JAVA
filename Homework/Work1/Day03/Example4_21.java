package Work1.Day03;

import java.util.Date;

/**
 * ********������
 */
class Tom{
    void f(double m){
        var width=108;
        var height=m;
        var date=new Date();
        System.out.printf("%d,%f,%s\n",width,height,date);
    }
}
public class Example4_21 {
    public static void main(String[] args) {
        var tom=new Tom();
        tom.f(6.18);
    }
}
