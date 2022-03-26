package Day12.test1;
/*
代码块
1、用来初始化类或对象
2、若存在修饰符，则只能用static
3、静态代码块:（1）内部可以有输出语句（2）随着类的加载而执行且只会在类被加载的时候执行一次
             对类中静态属性进行重新赋值（无法调用非静态结构）
   若定义了多个代码块，则按照先后顺序执行（静态永远在非静态前执行）

   非静态代码块：（1）内部可以有输出语句（2）随着对象的创建而执行且每创建一个对象就执行一次
               可对对象属性进行初始化(两结构都能调用)

 */
public class BlockTest {
    public static void main(String[] args) {
        String desc=Person.desc;
        Person p1=new Person();
    }
}

class Person{
    //属性
    String name;
    int age;
    static String desc="我是一个人";

    //代码块
    static {//静态
        System.out.println("hello,static block");
        desc="干饭";
    }
    static {
    }

    {//非静态
        System.out.println("hello,block");
        age=2;
    }

    //方法
    public Person(){
    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void eat(){
        System.out.println("人干饭");
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
    public static void info(){
        System.out.println("快乐人");
    }
}