package Day12.test12;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

/*
********************异常体系结构
* java.lang.Throwable
*      --------------java.lang.Error:一般不编写针对性代码处理
*      --------------java.lang.Exception:可以处理的异常
*
* 编译时异常(checked):FileNotFoundException
*
* 运行时异常(unchecked):NullPointerException，ArithmeticException，InputMismatchException
*                     NumberFormatException，ClassCastException，ArrayOutOfBoundsException
*
 */
public class ExceptionTest {
    //**********************编译时异常**********************
    //FileNotFoundException 未找到文件
    @Test
    public void test7(){
//        File file=new File("hello.txt");
//        FileInputStream fis=new FileInputStream(file);
//
//        int data=fis.read();
//        while(data!=-1){
//            System.out.print((char)data);
//            data=fis.read();
//        }
//        fis.close();
    }


    //*********************运行时异常********************
    //ArithmeticException 数学操作异常
    @Test
    public void test6(){
        int a=2,b=0;
        int c=a/b;
    }

    //InputMismatchException :输入不匹配异常
    @Test
    public void test5(){
        Scanner scanner=new Scanner(System.in);
        int score=scanner.nextInt();
        System.out.println(score);
        scanner.close();
    }

    //NumberFormatException 非数值类型转换异常
    @Test
    public void test4(){
        String str="123";
        str="abc";
        int num=Integer.parseInt(str);
    }

    //ClassCastException 类型转换异常
    @Test
    public void test3(){
        Object obj=new Date();
        String str=(String) obj;
    }

    //ArrayOutOfBoundsException 角标越界
    @Test
    public void test2(){
//      int arr[]=new int[10];
//      System.out.println(arr[10]);
      String str="abc";//StringArrayOutOfBoundsException
      System.out.println(str.charAt(3));
    }

    //NulPointerException 空指针
    @Test
    public void test1(){
        int []arr=null;
        System.out.println(arr[2]);
    }
}
