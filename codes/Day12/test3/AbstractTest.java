package Day12.test3;

import java.awt.*;

/**************AbstractTest��ʹ��
1�������
2�����νṹ���ࡢ������

3��abstract������--�������� :�޷�ʵ����������һ���й������������������ʵ����
                           �ṩ���������࣬���������ʵ����

4��abstract���η���--�����󷽷���ֻ�з����������޷�����   �������󷽷�����һ��Ϊ�����࣬��֮���������в�һ���г��󷽷�
                             ��������д��(��ӻ�ֱ��)���������г��󷽷���������ſ�ʵ����
                             ������δ��д��(��ӻ�ֱ��)���������г��󷽷���������ҲΪһ�������࣬��Ҫ��abstract����

 */
public class AbstractTest {
    public static void main(String[] args) {

        //һ��Person������ˣ��Ͳ�����ʵ����
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
    //���ǳ��󷽷�
//    public void eat(){
//    }

    //���󷽷�
    public abstract void eat();
    public void walk(){
        System.out.println("����·");
    }
}

class Student extends Person{

     public Student(String name,int age){
         super(name,age);
     }

     public void eat(){
         System.out.println("Ӫ��ʳ��");
     }
     public void breath(){
     }



}