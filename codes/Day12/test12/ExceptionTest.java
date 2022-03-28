package Day12.test12;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

/*
********************�쳣��ϵ�ṹ
* java.lang.Throwable
*      --------------java.lang.Error:һ�㲻��д����Դ��봦��
*      --------------java.lang.Exception:���Դ�����쳣
*
* ����ʱ�쳣(checked):FileNotFoundException
*
* ����ʱ�쳣(unchecked):NullPointerException��ArithmeticException��InputMismatchException
*                     NumberFormatException��ClassCastException��ArrayOutOfBoundsException
*
 */
public class ExceptionTest {
    //**********************����ʱ�쳣**********************
    //FileNotFoundException δ�ҵ��ļ�
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


    //*********************����ʱ�쳣********************
    //ArithmeticException ��ѧ�����쳣
    @Test
    public void test6(){
        int a=2,b=0;
        int c=a/b;
    }

    //InputMismatchException :���벻ƥ���쳣
    @Test
    public void test5(){
        Scanner scanner=new Scanner(System.in);
        int score=scanner.nextInt();
        System.out.println(score);
        scanner.close();
    }

    //NumberFormatException ����ֵ����ת���쳣
    @Test
    public void test4(){
        String str="123";
        str="abc";
        int num=Integer.parseInt(str);
    }

    //ClassCastException ����ת���쳣
    @Test
    public void test3(){
        Object obj=new Date();
        String str=(String) obj;
    }

    //ArrayOutOfBoundsException �Ǳ�Խ��
    @Test
    public void test2(){
//      int arr[]=new int[10];
//      System.out.println(arr[10]);
      String str="abc";//StringArrayOutOfBoundsException
      System.out.println(str.charAt(3));
    }

    //NulPointerException ��ָ��
    @Test
    public void test1(){
        int []arr=null;
        System.out.println(arr[2]);
    }
}
