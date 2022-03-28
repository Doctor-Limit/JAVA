package Day12.test12;

import java.io.*;

/*
********************方法重写中异常的规则
* 1、子类重写的方法输出的异常类型不大于父类被重写的方法的输出类型
* 2、
*
*
*
*
*
 */
public class OverrideTest {
    public static void main(String[] args) {

        OverrideTest test=new OverrideTest();

        test.display(new SubClass());

    }


   public void display(SuperClass s){
       try{
           s.method();
       }catch (IOException e){
           e.printStackTrace();
       }
   }

}

class SuperClass{
 public void method() throws IOException{


 }
}
class SubClass extends SuperClass{
 public void method() throws FileNotFoundException{


 }
}