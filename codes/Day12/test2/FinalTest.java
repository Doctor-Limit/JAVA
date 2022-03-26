package Day12.test2;
/*
final:最终的
native：运用底层c语言实现java功能（不显示）

final修饰的结构：类、方法、变量
1、final修饰一个类：此类不可被继承  例如：String类、System类、StringBuffer类
2、final修饰方法：此方法不可被重写  例如：Object类中getClass();
3、final修饰变量：此时的变量就称为一个常量
   (1)修饰属性：显示初始化、代码块中初始化、构造器初始化
   (2)修饰局部变量：使用final修饰形参时，表明此形参为一个常量，调用方法时，给该形参赋一个实参，赋值后，
                 只能在方法内使用此形参，不能重新赋值。

   static final :修饰属性（全局常量）
 */

public class FinalTest {
    final int width=10;
//    public void doWidth(){
//        width=20; 无法被修改
//    }


    public static void main(String[] args) {
        int num=10;
        num+=5;
    }
}
final class FinalA{

}
class AA{
    public final void show(){
    }
}
class BB extends AA{
//    public void show(){
//
//    }
}


