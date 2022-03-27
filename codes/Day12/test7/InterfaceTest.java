package Day12.test7;
/*
**********************�ӿڵ�ʹ��
1��ʹ��interface������
2��Java�У��ӿ�����Ϊ���й�ϵ
3��  JDK7����ǰ��ֻ�ܶ���ȫ�ֳ���(public static final)�ͳ��󷽷�(public abstract)
    JDK8����ȫ�ֳ�������󷽷������ɶ��徲̬������Ĭ�Ϸ���
4���޷����幹����--������ʵ����
5���ӿ�һ��ͨ����ȥʵ�֣�implement���ķ�����ʹ��
   ��ʵ���า���˽ӿ������г��󷽷���ʵ����Ϳ��Խ���ʵ����
   ��ʵ����δ�����˽ӿ������г��󷽷���ʵ�����Ҫ����Ϊ����
6����ʵ�ֶ���ӿ�--���ֲ���java���̳���ľ�����   ��5ͬ��
   ��ʽ:class AA extends BB interface CC,DD,EE
7���ӿںͽӿڼ�ɶ�̳�
**************************************
8���ӿڵľ���ʹ�þ��ж�̬��
9���ӿڿɿ�����һ�ֹ淶


 */
public class InterfaceTest {
    public static void main(String[] args) {
//        System.out.println(Flyable.MAX_SPEED);
//        System.out.println(Flyable.MIN_SPEED);

        Plane plane=new Plane();
        plane.fly();
        plane.stop();
    }

}

interface Attackable{
    void attack();
}

interface Flyable{
    //ȫ�ֳ���
    public static final int MAX_SPEED=7900;
    int MIN_SPEED=1;//Ĭ��Ϊȫ�ֳ���  ʡ����public static final

    //���󷽷�
    public abstract void fly();
    void stop();//Ĭ�ϳ��� ʡ��public abstract
}

class Plane implements Flyable{

    @Override
    public void fly() {
       System.out.println("���");
    }
    @Override
    public void stop() {
        System.out.println("��Ҫͣ����ѽ");
    }
}
abstract class Kite implements Flyable{

    @Override
    public void fly() {
    }
}

class Bullet extends Object implements Flyable,Attackable{
    @Override
    public void fly() {

    }
    @Override
    public void attack() {

    }

    @Override
    public void stop() {

    }
}