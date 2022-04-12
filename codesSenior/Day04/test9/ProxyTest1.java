package Day04.test9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ********概述：
 */

interface Star{
    void play(String ball);
    String interest();
}

//被代理类
class Fish implements Star{

    @Override
    public void play(String ball) {
        System.out.println("我会打"+ball);
    }

    @Override
    public String interest() {
        return "唱、跳、rap";
    }
}

//代理类
class ProxyStar{
    public static Object getStar(Object obj){
        starInvocationHandler handler = new starInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}

class starInvocationHandler implements InvocationHandler{

    private Object obj;
    public void bind(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj,args);
    }
}

public class ProxyTest1 {
    public static void main(String[] args) {

        Fish fish = new Fish();
        Star star = (Star) ProxyStar.getStar(fish);
        System.out.println(star.interest());
        star.play("篮球");

    }
}
