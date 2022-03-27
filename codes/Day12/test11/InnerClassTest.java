package Day12.test11;
/*
1、java中允许类A声明在类B中，则A为内部类，B为外部类
2、内部类分类：成员内部类，局部内部类

在局部内部类的方法中，若想调用局部内部类所声明的方法中的局部变量，
要求此局部变量声明为final（常量）

 */
public class InnerClassTest {


}

class Person{
    //静态/非静态成员内部类
   static class dog{

    }

    public void method(){
        //局部内部类
          class AA{

        }
    }
    public Person(){

        class BB{

        }
    }
}