package Day03.test9;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * ********概述：转换流的使用  从输入/输出的字符/字节流转换到输入/输出的字节/字符流
 *
 * 属于字符流（处理流）
 * InputStreamReader：将一个字节的输入流转化为字符的输出流
 * OutputStreamWriter：将一个字符的输出流转化为字节的输入流
 *
 * 提供字节流与字符流之间的转化
 *
 */
public class InputStreamReaderTest {

    /*
     InputStreamReader:字节输入流--》字符输入流
     */
    @Test
    public void test1() throws Exception{
        FileInputStream fis=new FileInputStream("E:\\chap\\codesSenior\\Day03\\test6\\hello.txt");
        //字节流-->字符流（提供编码格式），具体哪个字符集要看文件保存时使用的字符集
        InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
        char[] chars=new char[5];
        int len;
        while ((len=isr.read(chars))!=-1){
            String str=new String(chars,0,len);
            System.out.print(str);
        }
        isr.close();
    }

    @Test
    public void test2() throws Exception{

        FileInputStream fis=new FileInputStream("E:\\chap\\codesSenior\\Day03\\test6\\hello.txt");
        FileOutputStream fos=new FileOutputStream("E:\\chap\\codesSenior\\Day03\\test9\\hello.txt");

        InputStreamReader isr=new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");

        char[] chars=new char[20];
        int len;
        while ((len=isr.read(chars))!=-1){
            osw.write(chars,0,len);
        }
        isr.close();
        osw.close();
    }

}
