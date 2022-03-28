package Day12.test12;

import java.io.*;
/*
********************异常的处理方式二：throws+异常类型
* 1、“throws+异常类型”写在方法的声明处，指明此方法执行时，可能会抛出的异常类型，一旦方法
*    执行时出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常时，就会被抛出
*    异常代码后续的代码就不会被执行。
* 2、   try-catch-finally：真正处理掉异常
*       throws：只是将异常抛给了方法的调用者，并未将异常处理掉
* 3、选择try-catch-finally还是finally
*    3.1、若父类中没有throws方式处理异常，则子类重写的方法也不能throws，若子类中存在异常
*         通过try-catch-finally方式处理
*    3.2、若执行的方法中，先后调用了另外的几个方法，这几个方法是递进关系执行的，建议这几个方法通过throw方式处理
*         而执行的方法a考虑使用try-catch-finally处理
*
*
*
 */
public class ExceptionTest2 {

    public static void main(String[] args) {
        try{
           method2();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

 public static void method2() throws IOException{
     method1();
 }

    public static void method1() throws FileNotFoundException, IOException {
        File file=new File("hello.txt");
        FileInputStream fis=new FileInputStream(file);
        int data=fis.read();
        while(data!=-1){
            System.out.print((char)data);
            data=fis.read();
        }
        fis.close();
    }

}
