package Day03.test5;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * ********概述：
 * File类的使用：
 * 1、File类的一个对象，代表一个文件或一个文件目录
 * 2、在java.IO 包下
 * 3、File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 *    并未涉及到写入或读取文件内容的操作，若需要读取或写入文件内容，必须使用IO流完成
 * 4、后续File类的对象会作为参数传递到流的构造器中，指明读取或写入的终点
 *
 */
public class FileTest {
     /*
     1、创建file类的实例
        File file1=new File(String filePath);
        File file2=new File(String parentPath,String childPath);
        File file3=new File(File parentFile,String chilePath);

     2、相对路径：相较于某个路径下，指明的路径
        绝对路径：包含盘符在内的文件或文件目录的路径

     3、路径分隔符
        Windows:\\
        unix:/
    */
    @Test
    public void test1(){
        //只是作为内存层面的对象，输出该对象的路径而已，并未有具体实例对象

        //构造器一：
        File file=new File("hello.txt");//相对于当前文件
        System.out.println(file);

        //构造器二：
        File file1=new File("D:\\","Hacker");
        System.out.println(file1);

        //构造器三：
        File file2=new File(file1,"hello.txt");
        System.out.println(file2);
    }

    @Test
    public void test2(){
        File file1=new File("hello.txt");
        File file2=new File("d:\\io\\hi.txt");

        System.out.println(file1.getAbsoluteFile());//绝对路径
        System.out.println(file1.getPath());//获取路径
        System.out.println(file1.getName());//获取名称
        System.out.println(file1.getParent());//获取上层文件目录路径，若无，返回null
        System.out.println(file1.length());//获取文件长度（字节数），非目录长度
        System.out.println(file1.lastModified());//获取最近一次修改时间，毫秒值

        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    //只能对实体文件进行的操作，否则会报异常
    @Test
    public void test3(){

        File file=new File("E:\\chap\\codesSenior");//以文件名形式显示
        String[] list = file.list();
        for (String s :list) {
            System.out.println(s);
        }
        System.out.println();

        File[] files=file.listFiles();//以绝对路径方式显示
        for (File f:files) {
            System.out.println(f);
        }
    }

    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
      比如：file1.renameTo(file2)：要想确保返回true，file1要在硬盘中存在，且file2不在硬盘中存在
     */
    @Test
    public void test4(){
        File file1=new File("hello.txt");
        File file2=new File("d:\\io\\hi.txt");

        boolean renameTo=file1.renameTo(file2);
        System.out.println(renameTo);
    }

    @Test
    public void test5(){

        File file1=new File("hello.txt");

        System.out.println(file1.isDirectory());//是否文件目录
        System.out.println(file1.isFile());//是否为文件
        System.out.println(file1.exists());//是否存在
        System.out.println(file1.canRead());//是否可读
        System.out.println(file1.canWrite());//是否可写
        System.out.println(file1.isHidden());//是否隐藏

        System.out.println();

        file1=new File("d:\\io");
        System.out.println(file1.isDirectory());//是否文件目录
        System.out.println(file1.isFile());//是否为文件
        System.out.println(file1.exists());//是否存在
        System.out.println(file1.canRead());//是否可读
        System.out.println(file1.canWrite());//是否可写
        System.out.println(file1.isHidden());//是否隐藏
    }

    //创建硬盘中对应的文件或文件目录
    //删除文件时，该文件目录下不能有子目录或文件
    @Test
    public void test6() throws IOException {
        File file1=new File("hi.txt");
        if(!file1.exists()){
            file1.createNewFile();//创建文件
            System.out.println("创建成功");
        }else{file1.delete();//文件已存在
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7(){
        //文件目录的创建
        File file1=new File("d:\\io\\io1\\io3");

        boolean mkdir=file1.mkdir();//创建文件目录，若上层文件目录不存在，则创建失败
        if(mkdir) System.out.println("创建成功1");

        File file2=new File("d:\\io\\io2\\io4");
        boolean mkdir1=file2.mkdirs();//创建文件目录，若上层文件目录不存在则一并创建
        if(mkdir1) System.out.println("创建成功2");
    }
}
