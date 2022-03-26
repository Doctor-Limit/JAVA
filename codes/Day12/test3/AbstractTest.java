package Day12.test3;

import java.awt.*;

/**************AbstractTest的使用
1、抽象的
2、修饰结构：类、方法。

3、abstract修饰类--》抽象类 :无法实例化，类中一定有构造器，便于子类对象实例化
                           提供抽象类子类，让子类对象实例化

4、abstract修饰方法--》抽象方法：只有方法声明，无方法体   包含抽象方法的类一定为抽象类，反之，抽象类中不一定有抽象方法
                             若子类重写了(间接或直接)父类中所有抽象方法，此子类才可实例化
                             若子类未重写了(间接或直接)父类中所有抽象方法，此子类也为一个抽象类，需要用abstract修饰

 */
public class AbstractTest {
    public static void main(String[] args) {

        //一旦Person类抽象了，就不可以实例化
//        Person p1=new Person();
//        p1.eat();
//        p1.walk();

    }
}

abstract class Creature{
    public abstract void breath();
}

abstract class Person extends Creature{
    String name;
    int age;

    public Person(){
    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    //不是抽象方法
//    public void eat(){
//    }

    //抽象方法
    public abstract void eat();
    public void walk(){
        System.out.println("人走路");
    }
}

class Student extends Person{

     public Student(String name,int age){
         super(name,age);
     }

     public void eat(){
         System.out.println("营养食物");
     }
     public void breath(){
     }



}