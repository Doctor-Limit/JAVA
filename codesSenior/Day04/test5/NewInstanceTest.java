package Day04.test5;

import Day04.test5.Person;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * ********概述：通过反射创建对应的运行时类的对象
 *
 */
public class NewInstanceTest {

    @Test
    public void test1() throws Exception{
        Class<Person> clazz = Person.class;//类的泛型决定了方法的返回值

        /*
        newInstance():调用此方法创建运行时类的对象 默认调用空参构造器
        若要此方法正常创建运行时类的对象：(1):运行时类必须提供空参构造器
                                   (2):空参构造器的权限足够 通常为public

        在javabean中要求提供一个public的空参构造器：
        （1）便于通过反射，创建运行时类的对象
        （2）便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

         */
        Person obj=clazz.getDeclaredConstructor().newInstance();
        System.out.println(obj);

    }

    //反射的动态性：总体上框架，会在运行时根据不同的操作去匹配对应的结果
    @Test
    public void test2(){
        int num = new Random().nextInt(3);//0,1,2
        System.out.println(num);
        String classPath="";
        switch (num){
            case 0:classPath="java.util.Date";
            break;
            case 1:classPath="java.lang.Object";
            break;
            case 2:classPath="Day04.test5.Person";
            break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    创建一个指定类的对象
    classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return   clazz.getDeclaredConstructor().newInstance();
    }

}
