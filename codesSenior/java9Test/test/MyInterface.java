package java9Test.test;

/**
 * ********概述：
 *
 *
 */
public interface MyInterface {

    //权限修饰符的修饰都为public
    void methodAbstract();
    static void methodStatic(){
        System.out.println("静态方法");

    }
    default void methodDefault(){
        System.out.println("默认方法");
        methodPrivate();
    }

    //java9中允许接口中定义私有方法
    private void methodPrivate(){
        System.out.println("私有方法");
    }

}
