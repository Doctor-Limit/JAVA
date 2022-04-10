package Day03.test7;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ********概述：
 *   FileInputStream与FileOutputStream的使用  大体上与字符流相同
 *
 *   对于文本文件（TXT，java，c），使用字符处理
 *   对于非文本文件（jpg）使用字节流处理
 *
 */
public class FileInputOutputStreamTest {

    @Test
    public void test1() {
        FileInputStream fi=null;
        try {
            //造文件
            File file=new File("E:\\chap\\codesSenior\\Day03\\test7\\hello.txt");
            //造流
             fi=new FileInputStream(file);
            //读取操作
            byte[] bytes=new byte[10];
            int len;
            while((len=fi.read(bytes))!=-1){
                String str=new String(bytes,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            if(fi!=null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){

        long start=System.currentTimeMillis();
        String srcPath="E:\\chap\\codesSenior\\Day03\\test7\\1.jpg";
        String destPath="E:\\chap\\codesSenior\\Day03\\test7\\2.jpg";
        copyFile(srcPath,destPath);
        long end=System.currentTimeMillis();
        System.out.println("花费时间为："+(end-start));

    }

    public void copyFile( String srcPath,String destPath){
        FileInputStream fi=null;
        FileOutputStream fo=null;
        try {
            //实例化对象
            File file=new File(srcPath);
            File file1=new File(destPath);

            //创建输入输出流对象
            fi=new FileInputStream(file);
            fo=new FileOutputStream(file1);

            //进行读入及写出操作
            byte[] bytes=new byte[1024];
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
