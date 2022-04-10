package Day03.test8;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ********概述：缓冲流
 *   BufferInputStream   字节流
 *   BufferOutputStream
 *
 *   BufferReader        字符流  具有readLine()一次读一行，当为null是读取结束
 *   BufferWriter
 *
 *  作用：提高流的读取、写入速度
 *  原因：内部提供了一个缓冲区
 *
 *  处理流，就是套接在已有的流的基础上
 *
 *
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void test1() {
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            //1、造文件
            File srcFile=new File("E:\\chap\\codesSenior\\Day03\\test8\\1.jpg");
            File destFile=new File("E:\\chap\\codesSenior\\Day03\\test8\\2.jpg");
            //2、造节点流流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            //2.1、造缓冲流
             bis=new BufferedInputStream(fis);
             bos=new BufferedOutputStream(fos);
            //3、具体流的操作
            byte[] bytes=new byte[10];
            int len;
            while ((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
               // bos.flush();//刷新缓冲区
            }
            //4、流的关闭  先关外层的流，再关内层的流
            //关闭外层流的同时，内层的流也会关闭

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testWordCount(){
        BufferedReader br=null;
        BufferedWriter bw=null;

        try {
            Map<Character,Integer> map=new HashMap<>();
            br=new BufferedReader(new FileReader("E:\\chap\\codesSenior\\Day03\\test6\\hello.txt"));
            int c;
            while ((c=br.read())!=-1){
                char ch=(char) c;
                if(map.get(ch)==null){
                    map.put(ch,1);
                }else {
                    map.put(ch,map.get(ch)+1);
                }
            }
            bw=new BufferedWriter(new FileWriter("E:\\chap\\codesSenior\\Day03\\test8\\count.txt"));
            Set<Map.Entry<Character,Integer>> entrySet=map.entrySet();
            for(Map.Entry<Character,Integer> entry:entrySet){
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格="+entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键="+entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车="+entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行="+entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey()+"="+entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
