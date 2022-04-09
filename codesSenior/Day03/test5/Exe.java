package Day03.test5;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


/**
 * ********概述：
 */
public class Exe {

    @Test
    public void test1() throws IOException {
     File file1=new File("d:\\io\\");
     File file2=new File(file1.getParent(),"haha.txt");
     file2.createNewFile();

     String []arr=file1.list();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].endsWith(".jpg"))
                System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        File file=new File("d:\\io");
        deleteSubFile(file);
    }
    public static void printSubFile(File dir){
        long room=0;
        //打印目录的子文件
        File[] files=dir.listFiles();
        for(File f :files){
            if(f.isDirectory()){//为文件目录
                printSubFile(f);
            }else{//具体文件
                System.out.println(f.getAbsolutePath());
                room+=f.length();
            }
        }
        System.out.println(room);
    }
    public static void deleteSubFile(File dir){
        File[] files=dir.listFiles();
        for(File f: files){
            if(f.isDirectory()){
                deleteSubFile(f);
            }
            else {
                f.delete();
            }
        }
    }
}
