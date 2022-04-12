package Day04.test9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ********概述：动态代理
 *
 * 通过代理类对象实现对被代理类的动态处理
 *
 */

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("方法一");
    }
    public void method2(){
        System.out.println("方法二");
    }
    }

/*
实现动态代理问题？
1、如何根据被加载到内存中的被代理类，动态创建一个代理类及其对象
2、通过动态代理的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */

//代理类
class ProxyFactory{
    //调用此方法，返回一个代理类的对象，解决问题一
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj=obj;
    }

    //当通过代理类的对象，调用方法a时，就会自动的调用如下的方法:invoke()
    //将被代理类要执行的的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util=new HumanUtil();
        util.method1();

        //method即为代理类对象调用的方法，作为被代理类调用的方法
        //obj：被代理类的对象
        Object returnValue = method.invoke(obj, args);//方法返回值作为当前类中invoke方法的返回值

        util.method2();

        return returnValue;
    }
}

public class ProxyTest {
    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        //proxyInstance：代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动调用被代理类中同名的方法
        proxyInstance.eat("饭");
        System.out.println(proxyInstance.getBelief());

        NikeClothProxy nikeClothProxy = new NikeClothProxy();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothProxy);

        proxyClothFactory.productCloth();

    }
}
