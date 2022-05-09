package Work.homework6;

/**
 * ********概述：
 */
public class Person {

    protected double height;
    protected double weight;

    public void speakHello(){
        System.out.println("Hello");
    }
    public Person() {
    }

    public Person(double height,double weight){
        this.height=height;
        this.weight=weight;
    }

    public void averageWeight(){
        System.out.println("人重量");
    }

    public void averageHeight(){
        System.out.println("人身高");
    }

}
