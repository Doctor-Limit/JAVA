package Day04.test9;

/**
 * ********概述：静态代理
 * 代理类与被代理类在编译期间就已确定
 *
 */

interface ClothFactory{
    void productCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代理类进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }

    @Override
    public void productCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.productCloth();
        System.out.println("代理工厂后续的收尾工作");
    }
}

//被代理类
class NikeClothProxy implements ClothFactory{

    @Override
    public void productCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothProxy nike = new NikeClothProxy();
        //创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.productCloth();


    }
}
