package Day09;
/*
面向对象特征二：多态性

多态：运行时行为

多态性：可以理解为一个事物的多种形态,只适用于方法

具体使用：在编译期，只能调用父类中声明的方法，但在运行期，实际调用的是子类重写父类的方法

方法：编译看左边（父类），运行看右边（子类）

适用前提：存在类的继承关系  子类存在父类重写的方法

因为属性不接受继承，所以属性无多态性
属性：编译与运行都看左边

动态绑定：编译时调用为为父类，而方法的调用是在运行时确定的

 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1=new Person();
        p1.eat();

        Man man=new Man();
        man.eat();
        man.age=34;
        man.earnMoney();


        //父类的引用指向子类的对象
        Person p2=new Man();//多态性  只要是子类即可
        Person p3=new Woman();

        p2.eat();//运行调用的是子类重写父类的方法，但编译的时候依旧认为是调用父类方法------虚拟方法调用
        //实际父类方法并未被调用，故称为虚拟方法
        //但是无法调用子类特有的方法

        System.out.println(p2.id);//属性依旧是父类的属性



    }
}
