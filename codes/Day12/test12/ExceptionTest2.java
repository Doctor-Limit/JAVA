package Day12.test12;

import java.io.*;
/*
********************�쳣�Ĵ���ʽ����throws+�쳣����
* 1����throws+�쳣���͡�д�ڷ�������������ָ���˷���ִ��ʱ�����ܻ��׳����쳣���ͣ�һ������
*    ִ��ʱ�����쳣���Ի����쳣���봦����һ���쳣��Ķ��󣬴˶�������throws���쳣ʱ���ͻᱻ�׳�
*    �쳣��������Ĵ���Ͳ��ᱻִ�С�
* 2��   try-catch-finally������������쳣
*       throws��ֻ�ǽ��쳣�׸��˷����ĵ����ߣ���δ���쳣�����
* 3��ѡ��try-catch-finally����finally
*    3.1����������û��throws��ʽ�����쳣����������д�ķ���Ҳ����throws���������д����쳣
*         ͨ��try-catch-finally��ʽ����
*    3.2����ִ�еķ����У��Ⱥ����������ļ����������⼸�������ǵݽ���ϵִ�еģ������⼸������ͨ��throw��ʽ����
*         ��ִ�еķ���a����ʹ��try-catch-finally����
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
