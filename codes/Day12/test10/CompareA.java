package Day12.test10;
/*
***************************JDK8除了定义全局变量和抽象方法之外，还可定义静态方法、默认方法



 */
public interface CompareA {

    //静态方法
    public static void method1(){
        System.out.println("0");
    }

    //默认方法
     static void method2(){
        System.out.println("1");
    }

     default void method3(){
        System.out.println("2");
    }
}
