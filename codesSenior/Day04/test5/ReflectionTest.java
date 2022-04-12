package Day04.test5;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ********概述：
 *
 * 通过直接new的方式或new的方式都可调用公共结构，最好用哪个？
 * 建议直接new的方式
 *
 * 使用反射的方式（动态性）：当所需要创建的对象是根据具体操作来定时，建议使用反射动态创建对象
 *                      对象的类别具有不确定性
 *
 * 反射机制与面向对象中的封装性是否矛盾，如何看待两个技术？
 * 不矛盾
 * 封装性中私有结构建议不要使用（提供公共方法来实现相关功能）
 * 反射机制中，强行调用私有结构可能公共方法已实现相关功能，但是可以运用此机制调用
 *
 *
 * 关于java.lang.Class类
 * 1、类的加载过程：程序经过javac.exe命令后，会生成一个或多个字节码文件(.class结尾)，接下来使用
 *    java.exe命令对某个字节码文件进行解释运行，相当于蒋某个字节码文件加载到内存中，此过程称为类的
 *    加载，加载到内存中的类，我们称为运行时类，此运行时类，就称为Class的一个实例
 *
 * 2、Class实例就对应着一个运行时类,并会缓存一段时间且只有一个运行时类
 *
 * 3、加载到内存中的运行时类，会缓存一定时间，在此时间之内，可通过不同方式来获取此运行时类
 *
 *
 */
public class ReflectionTest {

    //反射前对于Person的操作
    @Test
    public void test1(){
        //创建Person类对象
        Person p1=new Person("Tom",12);

        //通过对象，调用其内部属性，方法
        p1.age=10;
        System.out.println(p1.toString());
        p1.show();

        //在Person外部不可通过Person对象调用其内部私有结构

    }

    //反射后的Person操作 invoke可无视权限直接调用
    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;
        //通过反射创建Person的对象
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p=(Person) obj;
        System.out.println(p);

        //通过反射，调用对象指定属性、方法
        Field age = clazz.getDeclaredField("age");//调用属性
        age.set(p,10);
        System.out.println(p.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射，可以调用Person类的私有结构：私有构造器，私有方法，私有属性
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1=(Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Petter");
        System.out.println(p1);

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "China");//想当于String
        System.out.println(nation);

    }

    //获取Class实例的方式
    @Test
    public void test3() throws Exception{
        //方式一：调用运行时类的属性：class
        Class<Person> clazz1=Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象调用getClass方法
        Person p1=new Person();
        Class clazz2=p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)  频率上使用更多
        Class clazz3 = Class.forName("Day04.test5.Person");
        System.out.println(clazz3);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);

        //以上需掌握

        //方式四：使用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("Day04.test5.Person");
        System.out.println(clazz4);

    }

}
