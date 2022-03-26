package Day11.test6;
/*
*******************静态(static)
使用static修饰属性：
* 静态变量随着类的加载而加载，通过类.静态变量来调用
* 静态变量的加载要早于对象的创建
* 由于类只会加载一次，而静态变量在内存中只存在一份，保存在方法的静态域中

使用static修饰方法：
*随着类的加载而加载，通过类.静态方法来调用
* 静态方法中，只能调用静态的方法或属性
* 非静态方法中，可调用非静态方法和属性，也可调用静态方法和属性

***********static注意点
在静态方法中，不能使用this关键字，super关键字
关于静态方法和静态属性的使用，从生命周期的角度去理解

 * 开发中，确定是否要声明为static的属性或方法？
 *属性：可被多个对象所共享的，不会随着对象的改变而改变
 *
 *方法：工具类，直接通过类.调用
 *
 *
 *
 */

class Circle{
    private double radius;
    private int id;
     private static int total;
     private static int init=1001;
     public Circle(){
         id=init++;
         total++;
     }

     public Circle(double radius){
        this();
        this.radius=radius;
     }
     public double findArea(){
         return 3.14*radius*radius;
     }

}

public class StaticTest {
    public static void main(String[] args) {

    }


}












