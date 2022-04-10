package Day04.test1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/**
 * ********概述： RandomAccessFile的使用
 * 1、直接继承于Object类，实现了DataInput和DataOutput接口
 * 2、 RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *    指定mode参数，来确定该文件的访问模式
 *    r：只读
 *    rw：读取及写入
 *
 * 3、若RandomAccessFile作为输出流时，写出的文件若不存在，则在执行过程中自动创建
 *    若文件存在，会对文件原有内容进行覆盖（默认从头覆盖）==》指针为0
 * 4、可以通过相关操作，实现插入数据的操作
 *
 *
 */
public class RandomAccessFileTest {

    @Test
    public void test1() throws Exception{
        RandomAccessFile ref1=new RandomAccessFile(new File("E:\\chap\\codesSenior\\Day03\\test6\\1.jpg"),"r");
        RandomAccessFile ref2=new RandomAccessFile(new File("E:\\chap\\codesSenior\\Day04\\test1\\1.jpg"),"rw");

        byte[] bytes=new byte[1024];
        int len;
        while ((len=ref1.read())!=-1){
            ref2.write(len);
        }
        ref1.close();
        ref2.close();
    }

    @Test
    public void test2() throws Exception{
        RandomAccessFile file1=new RandomAccessFile("E:\\chap\\codesSenior\\Day04\\test1\\hello.txt","rw");

        file1.seek(3);//将指针调到脚标为3的位置
        file1.write("why ".getBytes());

        file1.close();
    }

    //展现为插入效果
    @Test
    public void test3() throws Exception{
        RandomAccessFile file1=new RandomAccessFile("E:\\chap\\codesSenior\\Day04\\test1\\hello.txt","rw");

       file1.seek(3);//将指针调到3的位置
        //保存指针3后面的所有数据到StringBuilder中
       StringBuilder builder=new StringBuilder((int) new File("E:\\chap\\codesSenior\\Day04\\test1\\hello.txt").length());
       byte[] buffer=new byte[20];
       int len;
       while ((len=file1.read(buffer))!=-1){
           builder.append(new String(buffer,0,len));
       }
       //调回指针，并写入要插入的数据
       file1.seek(3);
       file1.write("xyz".getBytes());

       //将StringBuilder中的数据写入到文件中
        file1.write(builder.toString().getBytes());

        file1.close();
    }

    //使用字节输出流存储数据
    @Test
    public void test4() throws Exception{
        RandomAccessFile file1=new RandomAccessFile("E:\\chap\\codesSenior\\Day04\\test1\\hello.txt","rw");

        file1.seek(3);//将指针调到3的位置
        //保存指针3后面的所有数据到FileOutputStream中
        ByteArrayOutputStream bos=new ByteArrayOutputStream((int) new File("E:\\chap\\codesSenior\\Day04\\test1\\hello.txt").length());
        byte[] buffer=new byte[20];
        int len;
        while ((len=file1.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }
        //调回指针，并写入要插入的数据
        file1.seek(3);
        file1.write("xyz".getBytes());
        //将输出流的数据写出
        file1.write(bos.toString().getBytes());

        bos.close();
        file1.close();

    }

}
