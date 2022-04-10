package Day03.test6;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * ********概述：
 * 一、流的分类
 * 1、操作数据单位：字节流，字符流(2字节)
 * 2、数据流向：输入流，输出流
 * 3、流的角色：节点流，处理流
 *
 * 字节流读取非文本文件，字符流读取文本文件
 *
 * 二、流的体系结构
 *  抽象基类       节点流（文件流）       缓冲流（处理流的一种）
 *  InputStream   FileInputStream     BufferInputStream   字节流
 *  OutputStream  FileOutputStream    BufferOutputStream
 *
 *  Reader        FileReader          BufferReader        字符流
 *  Writer        FileWriter          BufferWriter
 *
 */
public class FileReaderWriterTest {

    /*
    read():返回读入的字符，若达到文件末尾，返回-1
    异常的处理：为了保证一定可执行关闭操作，要用try-catch-finally
    读入的文件一定要存在，否则会报FileNotFoundException

    不能使用字符类型来处理图片等字节数据
     */
    @Test
    public void test1() {
        //实例化file对象，指明操作队对象
        File file=new File("E:\\chap\\codesSenior\\Day03\\test6\\hello.txt");
        //提供具体的流
        FileReader fr= null;
        try {
            fr = new FileReader(file);
        //数据的读入过程
        int data=fr.read();//返回读入的字符，若达到文件末尾，返回-1
        while (data!=-1){
            System.out.print((char) data+" ");
            data=fr.read();
        }
        //二者等价
//        int data;
//        while ((data=fr.read())!=-1){
//            System.out.println(data);
//        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //流的关闭操作
            try {
                if(fr!=null)
                 fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对read()操作，使用read的重载方法
    @Test
    public void test2() {
        //File类的实例化
        File file=new File("E:\\chap\\codesSenior\\Day03\\test6\\hello.txt");
        //FileReader流的实例化
        FileReader fr=null;
        try {
            fr=new FileReader(file);
            //读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中字符的个数，若达到文件末尾，则返回-1
            char[] cbuf=new char[5];
            int len;
            while ((len=fr.read(cbuf))!=-1){
                //当未全部覆盖数组元素时，会打印上次的元素
//                for (int i = 0; i < 5; i++) {
//                    System.out.print(cbuf[i]+" ");
//                }
                //
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]+" ");
//                }
                //与直接将次数写为5的方式错误相同
//                String str=new String(cbuf);
//                System.out.print(str);

                String str=new String(cbuf,0,len);//对结果为-1前的数据进行读入
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(fr!=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    从内存中写出数据到硬盘的文件里

    输出操作：对应的File可以不存在，不会报异常，
           若不存在，输出的过程中，会自动创建此文件
           若存在，若流使用的构造器FileWriter(file,false)/FileWriter(file),对原有文件会覆盖
                  若流使用的构造器FileWriter(file,true),则会在原有文件的后面追加写入数据
     */
    @Test
    public void test3() {
        //提供File实例对象
        File file=new File("E:\\chap\\codesSenior\\Day03\\test6\\hello.txt");
        //提供了FileWriter的对象，用于数据的写出
        FileWriter fr=null;
        try {
         fr=new FileWriter(file,true);
            //写出的操作
            fr.write("kksk\n");
            //流资源的关闭

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr!=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读入及写出操作的体现
    @Test
    public void test4() {
        FileReader fr=null;
        FileWriter fw=null;
        //创建File实例化对象
        try {
            File srcFile=new File("E:\\chap\\codesSenior\\Day03\\test6\\hello.txt");
            File destFile=new File("E:\\chap\\codesSenior\\Day03\\test6\\hello1.txt");

            //创建输入、输出流的对象
            fr=new FileReader(srcFile);
            fw=new FileWriter(destFile);

            //进行读入及写出的操作
            char[] chars=new char[5];
            int len;//每次读入到char数组的数据个数
            while ((len=fr.read(chars))!=-1){
               fw.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //对流资源的关闭
            if(fr!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr!=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //采用字节流去赋值图片  FileReader-->FileInputStream  FileWriter-->FileOutputStream  char[] -->byte[]
    //将字符型赋值变量全替换为字节型赋值变量即可
    @Test
    public void test5() {
        FileInputStream fi=null;
        FileOutputStream fo=null;
        try {
            //实例化对象
            File file=new File("E:\\chap\\codesSenior\\Day03\\test6\\1.jpg");
            File file1=new File("E:\\chap\\codesSenior\\Day03\\test6\\2.jpg");

            //创建输入输出流对象
             fi=new FileInputStream(file);
             fo=new FileOutputStream(file1);

            //进行读入及写出操作
            byte[] bytes=new byte[10];
            int len;
            while ((len=fi.read(bytes))!=-1){
                fo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //数据流的关闭
            if(fo!=null) {
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fi!=null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
