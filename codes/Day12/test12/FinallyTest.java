package Day12.test12;

import org.junit.Test;
import java.io.*;

/*
********************try-catch-finally中finally的使用
*
* 1、finally可选
* 2、finally中声明的一定是会被执行的代码，即使catch语句中也出现异常，catch中存在return语句等情况
* 3、像数据库连接、输入输出流、网络编程Socket等资源，JVM无法自动回收，需要手动进行资源释放，此时将资源释放
*    的操作，要放在finally资源中
*
 */
public class FinallyTest {

    @Test
    public void test7() throws IOException {
        FileInputStream fis=null;
        try{
            File file=new File("hello.txt");
            fis=new FileInputStream(file);

            int data=fis.read();
            while(data!=-1){
                System.out.print((char)data);
                data=fis.read();
            }
        }catch (FileNotFoundException e){
        } catch (IOException e){
        }finally {
           try {
               if(fis!=null)
               fis.close();
           }catch (Exception e){
               e.printStackTrace();
           }
        }
    }


    @Test
    public void test6(){
        try {
            int a = 2, b = 0;
            int c = a / b;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("你给路达哟");
        }
    }

}
