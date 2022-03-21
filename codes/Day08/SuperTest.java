package Day08;


public class SuperTest {
    public static void main1(String[] args) {
//     Student s=new Student();
//     s.study();
//     s.show();
     /*
super 可调用属性、方法、构造器（构造函数）
在子类中，通过使用super.属性或super.方法来调用父类中的属性或方法，习惯省略super
仅当子类定义了与父类同名的属性时，若想调用父类声明的属性，则需以super.属性的方式来调用，表明调用的是父类中的属性
super:调用最近的同名属性父类中的属性及方法，有多个父类时，遵循就近原则

可在子类的构造器中显式使用super(形参列表)的方式，调用父类声明指定的构造器
super(形参列表)的使用必须在类构造器的首行
在类构造器中，对this(形参列表)和super（形参列表）只能二选一
构造函数首行都没有时，默认调用父类中空参的构造器
     */
        Student s1=new Student("Tom",23,"IT");
        s1.show();
    }
    public static void main(String[] args) {





    }
}
