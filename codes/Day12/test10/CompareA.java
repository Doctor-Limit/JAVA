package Day12.test10;
/*
***************************JDK8���˶���ȫ�ֱ����ͳ��󷽷�֮�⣬���ɶ��徲̬������Ĭ�Ϸ���



 */
public interface CompareA {

    //��̬����
    public static void method1(){
        System.out.println("0");
    }

    //Ĭ�Ϸ���
     static void method2(){
        System.out.println("1");
    }

     default void method3(){
        System.out.println("2");
    }
}
