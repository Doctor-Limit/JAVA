package Day12.test12;

import org.junit.Test;
import java.io.*;

/*
********************try-catch-finally��finally��ʹ��
*
* 1��finally��ѡ
* 2��finally��������һ���ǻᱻִ�еĴ��룬��ʹcatch�����Ҳ�����쳣��catch�д���return�������
* 3�������ݿ����ӡ������������������Socket����Դ��JVM�޷��Զ����գ���Ҫ�ֶ�������Դ�ͷţ���ʱ����Դ�ͷ�
*    �Ĳ�����Ҫ����finally��Դ��
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
            System.out.println("���·��Ӵ");
        }
    }

}
