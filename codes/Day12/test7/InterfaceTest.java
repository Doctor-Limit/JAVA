package Day12.test7;
/*
**********************接口的使用
1、使用interface来定义
2、Java中，接口与类为并列关系
3、  JDK7及以前：只能定义全局常量(public static final)和抽象方法(public abstract)
    JDK8：除全局常量与抽象方法，还可定义静态方法。默认方法
4、无法定义构造器--》不可实例化
5、接口一般通过类去实现（implement）的方法来使用
   若实现类覆盖了接口中所有抽象方法，实现类就可以进行实例化
   若实现类未覆盖了接口中所有抽象方法，实现类就要定义为抽象
6、可实现多个接口--》弥补了java单继承类的局限性   与5同理
   格式:class AA extends BB interface CC,DD,EE
7、接口和接口间可多继承
**************************************
8、接口的具体使用具有多态性
9、接口可看做是一种规范


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
    //全局常量
    public static final int MAX_SPEED=7900;
    int MIN_SPEED=1;//默认为全局常量  省略了public static final

    //抽象方法
    public abstract void fly();
    void stop();//默认抽象 省略public abstract
}

class Plane implements Flyable{

    @Override
    public void fly() {
       System.out.println("起飞");
    }
    @Override
    public void stop() {
        System.out.println("不要停下来呀");
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