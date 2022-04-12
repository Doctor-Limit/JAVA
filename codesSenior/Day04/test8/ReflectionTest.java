package Day04.test8;

import Day04.test6.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ********概述：调用运行时类的结构：属性、方法、构造器
 *
 *
 */
public class ReflectionTest {

    //通常不采用  只能获取声明权限为public的属性
    @Test
    public void testField1() throws Exception{
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p= (Person) clazz.getDeclaredConstructor().newInstance();

        //获取指定属性:只能获取声明权限为public的属性
        Field id = clazz.getField("id");

        /*
        设置当前属性的值
        set():参数1：指明设置哪个对象的属性  参数2：将此属性值设置为多少
         */
        id.set(p,1001);

        //获取当前属性的值
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    //操作运行时类的指定属性
    @Test
    public void testField2() throws Exception{
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p= (Person) clazz.getDeclaredConstructor().newInstance();

        //clazz.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name=clazz.getDeclaredField("name");

        //保证可访问当前属性
        name.setAccessible(true);
        //获取、设置指定对象的属性值
        name.set(p,"Tom");
        System.out.println(name.get(p));

    }

    //操作运行时类的指定方法
    @Test
    public void testMethod() throws Exception{
        Class clazz = Person.class;

        //创建知道那个运行时类的对象
        Person p = (Person) clazz.getDeclaredConstructor().newInstance();

        //获取指定方法
        //getDeclaredMethod():参数1 指明获取的方法的名称  参数2：指明获取的方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);

        //保证当前方法可访问
        show.setAccessible(true);

        //invoke():参数1 方法调用者  参数2：给方法形参赋值的实参
        //invoke()的返回值即为对应类中调用的方法的返回值
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

        System.out.println("******调用静态方法******");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //若调用的运行时类的方法没有返回值，则此invoke()返回null
        //Object returnVal = showDesc.invoke(Person.class);
        //当方法声明为静态时，此时调用的类只有初始被加载进来的类，所以可不传参invoke中
        Object returnVal = showDesc.invoke(null);
        System.out.println(returnVal);//null

    }

    //调用运行时类的指定构造器
    @Test
    public void testConstructor() throws Exception{
        Class clazz = Person.class;

        /*
        获取指定的构造器
        getDeclaredConstructor():参数 指明构造器的参数列表
         */
        Constructor constructor=clazz.getDeclaredConstructor(String.class);

        //保证构造器可访问的
        constructor.setAccessible(true);

        //调用此构造器创建运行时类的对象
        Person p= (Person) constructor.newInstance("Tom");
        System.out.println(p);
        
    }

}
