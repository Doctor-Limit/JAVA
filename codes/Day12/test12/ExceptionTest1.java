package Day12.test12;

import org.junit.Test;

import javax.imageio.IIOException;
import java.io.*;

/*
***********************异常处理:抓抛模型
*
* 过程一："抛" ：程序在正常运行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象
*              并将此对象抛出给调用者，一旦抛出对象，后面的代码就不再处理
*
*              关于异常对象的产生：（1）系统自动生成的异常对象
*                              （2）手动产生一个异常对象，并抛出(throw)--》产生异常对象的方法
*
* 过程二：”抓“：异常的处理方式（1）try-catch-finally (2)throws（处理异常对象的方法）
*
* (1)try-catch-finally处理：根据出现异常的不同选择不同的方法去处理
*  try{
*    可能出现异常的代码
* }catch(异常类型1 变量名1){
*     处理异常的方式一
* }catch(异常类型二 变量名二){
*     处理异常的方式二
* }
*........
* finally{
*    一定会执行的代码
* }
* 1、finally是可选的
* 2、使用try将异常代码封装起来，一旦出现异常，会生成一个对应异常类的对象，根据此对象类型
*    去catch中进行匹配
* 3、一旦try中的异常对象匹配到某一个catch，就进入catch中进行异常的处理，一旦处理完成，在没有写finally的情况下，
*    就会跳出当前try-catch结构，继续执行后面的代码
* 4、catch中异常类型若无子父类关系，则声明顺序随便
*    若存在子父类关系，则子类必须要放在父类之前，否则报错
* 5、常用处理方式：（1）String getMessage（） （2）printStackTrace（）：寻找出现代码异常的该行
* 6、在try结构中声明的变量，出了该结构后，就不可再被调用
* 7、try-catch结构可以嵌套
*
* 总结：(1)使用try-catch-finally结构处理编译时异常，使得程序在编译时不再报错，但在运行时仍可能报错
*      想当于使用try-catch-finally将一个编译时可能出现的异常延迟到运行时再出现
*      (2)通常不对运行时异常编写try-catch-finally语句，但对于编译时异常，一定要进行异常处理
*
*
*  在退出方法前（产生异常或返回），都要先执行finally中的语句
 */
public class ExceptionTest1 {

    //编译可通过，但运行时依旧有可能报错
    @Test
    public void test7(){
        try{
        File file=new File("hello.txt");
        FileInputStream fis=new FileInputStream(file);

        int data=fis.read();
        while(data!=-1){
            System.out.print((char)data);
            data=fis.read();
        }
        fis.close();
        }catch (FileNotFoundException e){
        } catch (IOException e){
        }
    }


    @Test
    public void test4(){
        String str="123";
        str="abc";
        try{
        int num=Integer.parseInt(str);}
        catch (NullPointerException e){
            System.out.println("出现空指针异常");
        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage());//获取此异常对象中的信息
            System.out.println("出现数值转换异常");
            e.printStackTrace();
        }
        System.out.println("Hello World");
    }

}
