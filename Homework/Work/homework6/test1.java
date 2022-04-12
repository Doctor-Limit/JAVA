package Work.homework6;

/**
 * ********概述：
 */
public class test1 {
    public static void main(String[] args) {
        Person p1=new Person();
        Chinese c1=new Chinese();
        Beijingman b1=new Beijingman();
        American a1=new American();
        c1.averageHeight();
        p1.averageHeight();
        b1.averageHeight();
        a1.averageHeight();
        c1.speakHello();
        p1.speakHello();
        b1.speakHello();
        a1.speakHello();
        p1.averageWeight();
        b1.averageWeight();
        c1.averageWeight();
        a1.averageWeight();
        c1.chinaGongFu();
        b1.beijingPera();
        a1.americanBoxing();

    }
}
