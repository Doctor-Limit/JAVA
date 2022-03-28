package Day12.test12;

import java.io.*;

/*
********************������д���쳣�Ĺ���
* 1��������д�ķ���������쳣���Ͳ����ڸ��౻��д�ķ������������
* 2��
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