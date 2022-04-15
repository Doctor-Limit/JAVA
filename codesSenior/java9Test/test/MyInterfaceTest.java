package java9Test.test;

/**
 * ********概述：
 */
public class MyInterfaceTest implements MyInterface{
    @Override
    public void methodAbstract() {
        System.out.println("实现类重写抽象");
    }
//
//    @Override
//    public void methodDefault() {
//        System.out.println("实现类重写默认");
//    }

    public static void main(String[] args) {
        //接口的静态方法只能由接口去调用
        MyInterface.methodStatic();
        //接口的实现类不能调用接口的静态方法
        //MyInterfaceTest.methodStatic();

        //不允许调用接口中的私有方法
        MyInterfaceTest mt1=new MyInterfaceTest();
        mt1.methodAbstract();
        mt1.methodDefault();
    }
}
