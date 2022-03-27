package Day12.test10;

public class SubClassTest implements CompareA{
    public static void main(String[] args) {
        SubClass s=new SubClass();
        //接口中的静态方法只能通过接口类调用
        //s.method1();
        CompareA.method1();
        //若重写了类中的默认方法，调用的依旧是重写后的方法
        CompareA.method2();

        s.method3();
        //若子类（或实现类）继承的父类和实现的接口声明了同名同参数的方法
        //若子类并未重写，默认调用的是父类中同名同参数的方法--》类优先识别
        //若实现类实现了多个接口，且这多个接口定义了同名同参数的默认方法
        //那么在未重写此方法的情况下，报错--》接口冲突
        //所以必须要在实现类中重写此方法
    }
}

class SubClass extends SuperClass implements CompareA,CompareB{

    public static void method1(){
        System.out.println("3");
    }
    //在子类（或实现类）的方法中调用父类、接口中被重写的方法
    public void myMethod(){
        method3();//调用自己定义的重写的方法
        super.method3();//调用父类声明的

        CompareB.method3();//调用默认静态方法
        CompareA.super.method3();//调用接口中的非静态方法

    }
}