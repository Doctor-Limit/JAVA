package Day11.test3;

import org.junit.Test;

/*
********************包装类的使用：
1、java提供了8种基本数据类型的包装类，使用基本数据类型的变量具有类的特征(byte,short,int,long,float,double,char,boolean)
2、基本数据类型、包装类、String三者之间相互转化
*
 */
public class WrapperTest {

    //String类型--》基本数据类型，包装类  调用包装类的parse()方法
    @Test
    public void test6(){
         String str1="123";
         //int num1=(int)str1;  不存在子父类关系所以无法强转

         int num1=Integer.parseInt(str1);
         System.out.println(num1+1);

    }

    //基本数据类型，包装类--》String类，调用String重载的valueOf（）方法
    @Test
    public void test5(){
        int num1=10;
        String str1=num1+" "; //直接连接运算

        float f1=12.5f;
        String str2=String.valueOf(f1);//"12.6"
    }

    //JDK5.0的新特性，自动装箱与自动拆箱
    @Test
    public void test4(){
        int num2=10;
        Integer in1=num2; //自动装箱  基本数据类型--》包装类

        int num1=in1;//自动开箱  包装类--》基本数据类型

    }

    @Test   //将基本数据转化为类，实现数据的多态
    public void test3(){
        int num1=10;
        method(num1);
    }

    public void method(Object obj){
    }

    @Test  //基本数据类型--》包装类
    //在jdk9.0后基本已被废弃
   public void test1(){
//       int num1=10;
//       Integer in1=new Integer(num1);  将基本数据类型整形常量10包装进该类中
//       System.out.println(in1.toString());

       //异常,只能为一个具体的数
//        Integer in2=new Integer("123");
//        System.out.println(in2.toString());

       // Float f1=new Float(10.5f);

       //Boolean b1=new Boolean(true);
   }
   //包装类--》基本数据类型
    @Test
    public void test2(){
//        Integer in1=new Integer(10);
//        int in1=in1.intValue(); 通过将类转化为基本数据类型来实现相关算术运算

    }
}
