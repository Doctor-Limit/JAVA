package Day02.test5;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

/**
 * ********概述：注解的使用Annotation
 *
 * 1、Annotation的使用
 *   生成文档相关注解
 *   在编译时进行格式检查
 *   跟踪代码依赖性，实现替代配置文件功能
 *
 * 2、自定义注解
 * 注解声明为:@ +
 * 内部定义成员，通常用value表示
 * 可以指定成员的默认值，使用default定义
 * 若自定义注解无成员，表明是一个标识作用
 *
 * 若注解有成员，使用时要定义值
 * 自定义注解必须配上注解的信息处理流程(使用反射)才有意义
 * 自定义注解一般都会指明两个元注解：Retention、Target
 *
 * 3、元注解：对现有的注解进行解释说明的注解
 *
 * Retention:指定所修饰的Annotation的生命周期：SOURCE\CLASS(默认行为)\RUNTIME
 *           只有声明为RUNTIME的生命周期的注解，才能通过反射获取
 * Target:用于指定被修饰的Annotation能用于修饰哪些程序元素
 * **********************使用频率较低
 * Documented:表示所修饰的注解再被javadoc解析时，保留下来
 * Inherited:被它修饰的Annotation将具有继承性
 *
 * 4、通过反射获取注解信息
 *
 * 5、jdk8 注解新特性：可重复注解，类型注解
 *         可重复注解：在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *                  MyAnnotation的Target和Retention等元注解和MyAnnotations相同
 *         类型注解：
 *
 */

//@MyAnnotation()//给value赋值
//@MyAnnotations({@MyAnnotation(value = "hello"),@MyAnnotation(value = "hi")})//jdk8之前写法
  @MyAnnotation(value = "hi")
  @MyAnnotations(value = "hello")
class Person{
    private String name;
    private int age;

    public Person(){
    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人干饭");
    }

}
interface Info{
    void show();
}
class Student extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {
        System.out.println();
    }
}

public class AnnotationTest {

    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
    public static void main(String[] args) {
        Person p=new Student();
        p.walk();

        //不对未使用进行警告
        @SuppressWarnings("unused")//抑制编译警告
        int num=10;
    }

}
