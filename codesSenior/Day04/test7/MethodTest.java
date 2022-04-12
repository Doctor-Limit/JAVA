package Day04.test7;

import Day04.test6.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * ********概述：运行时类方法结构
 * 
 */
public class MethodTest {
    
    @Test
    public void test1(){
        Class clazz = Person.class;
        
        //getMethods():获取当前运行时类及所有父类声明权限为public的方法
        Method[] methods = clazz.getMethods();
        for (Method m :methods) {
            System.out.println(m);
        }

        //getDeclaredMethods():获取当前运行时类中声明的所有方法(不包含父类中声明的方法)
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m :methods1) {
            System.out.println(m);
        }
    }

    //@Xxx
    //权限修饰符  返回值类型  方法名(参数类型1 形参名1,...) throws XxxException
    @Test
    public void test2(){
        //获取方法声明注解
        Class clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m:methods){

            //获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a:annos){
                System.out.print(a);
            }

            //权限修饰符
            System.out.print(Modifier.toString(m.getModifiers())+"\t");

            //返回值类型
            System.out.print(m.getReturnType().getName()+"\t");

            //方法名
            System.out.print(m.getName()+"\t");
            System.out.print("(");

            //形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes==null||parameterTypes.length==0)){
                for (int i=0;i<parameterTypes.length;i++){
                    if(i==parameterTypes.length-1) {
                        System.out.print(parameterTypes[i].getName()+" args_"+i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName()+" args_"+i+",");
                }
            }
            System.out.print(")");

            //抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(!(exceptionTypes==null||exceptionTypes.length==0)){
                System.out.print("throws");
                for(int i=0;i<exceptionTypes.length;i++){
                    if(i==exceptionTypes.length-1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName()+",");
                }
            }

            System.out.println();

        }
    }
}
