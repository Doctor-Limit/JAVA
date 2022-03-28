package Day12.test12;

import org.junit.Test;

import javax.imageio.IIOException;
import java.io.*;

/*
***********************�쳣����:ץ��ģ��
*
* ����һ��"��" ���������������еĹ����У�һ�������쳣���ͻ����쳣���봦����һ����Ӧ�쳣��Ķ���
*              �����˶����׳��������ߣ�һ���׳����󣬺���Ĵ���Ͳ��ٴ���
*
*              �����쳣����Ĳ�������1��ϵͳ�Զ����ɵ��쳣����
*                              ��2���ֶ�����һ���쳣���󣬲��׳�(throw)--�������쳣����ķ���
*
* ���̶�����ץ�����쳣�Ĵ���ʽ��1��try-catch-finally (2)throws�������쳣����ķ�����
*
* (1)try-catch-finally�������ݳ����쳣�Ĳ�ͬѡ��ͬ�ķ���ȥ����
*  try{
*    ���ܳ����쳣�Ĵ���
* }catch(�쳣����1 ������1){
*     �����쳣�ķ�ʽһ
* }catch(�쳣���Ͷ� ��������){
*     �����쳣�ķ�ʽ��
* }
*........
* finally{
*    һ����ִ�еĴ���
* }
* 1��finally�ǿ�ѡ��
* 2��ʹ��try���쳣�����װ������һ�������쳣��������һ����Ӧ�쳣��Ķ��󣬸��ݴ˶�������
*    ȥcatch�н���ƥ��
* 3��һ��try�е��쳣����ƥ�䵽ĳһ��catch���ͽ���catch�н����쳣�Ĵ���һ��������ɣ���û��дfinally������£�
*    �ͻ�������ǰtry-catch�ṹ������ִ�к���Ĵ���
* 4��catch���쳣���������Ӹ����ϵ��������˳�����
*    �������Ӹ����ϵ�����������Ҫ���ڸ���֮ǰ�����򱨴�
* 5�����ô���ʽ����1��String getMessage���� ��2��printStackTrace������Ѱ�ҳ��ִ����쳣�ĸ���
* 6����try�ṹ�������ı��������˸ýṹ�󣬾Ͳ����ٱ�����
* 7��try-catch�ṹ����Ƕ��
*
* �ܽ᣺(1)ʹ��try-catch-finally�ṹ�������ʱ�쳣��ʹ�ó����ڱ���ʱ���ٱ�����������ʱ�Կ��ܱ���
*      �뵱��ʹ��try-catch-finally��һ������ʱ���ܳ��ֵ��쳣�ӳٵ�����ʱ�ٳ���
*      (2)ͨ����������ʱ�쳣��дtry-catch-finally��䣬�����ڱ���ʱ�쳣��һ��Ҫ�����쳣����
*
*
*  ���˳�����ǰ�������쳣�򷵻أ�����Ҫ��ִ��finally�е����
 */
public class ExceptionTest1 {

    //�����ͨ����������ʱ�����п��ܱ���
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
            System.out.println("���ֿ�ָ���쳣");
        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage());//��ȡ���쳣�����е���Ϣ
            System.out.println("������ֵת���쳣");
            e.printStackTrace();
        }
        System.out.println("Hello World");
    }

}
