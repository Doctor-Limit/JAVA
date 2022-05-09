package Work1.Day04;

/**
 * ********概述：
 */
class 类人猿{
    void crySpeak(String s){
        System.out.println(s);
    }
}
class People1 extends 类人猿{
    void computer(int a,int b){
        int c=a*b;
        System.out.println(c);
    }

    @Override
    void crySpeak(String s) {
        System.out.println("****"+s+"****");
    }
}
public class Example5_10 {
    public static void main(String[] args) {

        类人猿 monkey;
        People1 geng=new People1();
        System.out.println(geng instanceof People1);
        monkey=geng;
        System.out.println(monkey instanceof People1);
        monkey.crySpeak("I love this game");
        People1 people1=(People1) monkey;
        people1.computer(10,10);

    }
}
