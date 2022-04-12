package Day04.test9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ********概述：
 */

interface actor{
    void act(String play);
    String teleplay();
}

class Kun implements actor{
    @Override
    public void act(String play) {
        System.out.println("我演过"+play);
    }

    @Override
    public String teleplay() {
        return "不熟我自己吃了它满意了吧";
    }
}

//被代理类
class ProxyKun{
    public static Object getActor(Object obj){
        kunInvocationHandler handler = new kunInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}

class kunInvocationHandler implements InvocationHandler{

    private Object obj;
    public void bind(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj,args);
    }
}

public class ProxyTest3 {
    public static void main(String[] args) {
        Kun kun = new Kun();
        actor actor = (Day04.test9.actor) ProxyKun.getActor(kun);
        actor.act("你这瓜保熟吗？");
        System.out.println(actor.teleplay());
    }
}
