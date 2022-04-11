package Day04.test2;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ********概述：
 *
 * 二者相互给予反馈时，客户端需要提供发送结束指示确保可正常运行
 *
 */
public class TCPTest3 {

    @Test
    public void client() {

        Socket socket=null;
        OutputStream os=null;
        FileInputStream fis=null;
        InputStream is=null;
        ByteArrayOutputStream bos=null;
        try {
            InetAddress ine1=InetAddress.getByName("127.0.0.1");
            socket=new Socket(ine1,666);
            os=socket.getOutputStream();
            fis=new FileInputStream(new File("E:\\chap\\codesSenior\\Day04\\test2\\1.jpg"));
            byte[] bytes=new byte[1024];
            int len;
            while ((len=fis.read(bytes))!=-1){//read默认会阻塞，不知道是否客户端数据是否已发送完成，会持续循环
                os.write(bytes,0,len);
            }

            //发出数据已完全发送完毕的指示，此时read会结束
            socket.shutdownOutput();

            //客户端将服务器端返回的反馈信息显示到控制台上
            is = socket.getInputStream();
            bos=new ByteArrayOutputStream();
            byte[] bytes1=new byte[1024];
            int len1;
            while ((len1=is.read(bytes1))!=-1){
                bos.write(bytes1,0,len1);
            }
            System.out.println(bos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null) {
                try {
                    is.close();
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
    public void Server() {

        ServerSocket ss=null;
        Socket socket=null;
        InputStream is=null;
        FileOutputStream fos=null;
        OutputStream os=null;
        try {
            ss=new ServerSocket(666);
            socket = ss.accept();
            is=socket.getInputStream();
            File file=new File("E:\\chap\\codesSenior\\Day04\\test2\\3.jpg");
            fos=new FileOutputStream(file);
            byte[] bytes=new byte[1024];
            int len;
            while ((len=is.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
            System.out.println("成功生成对象");


            //服务器端给予反馈
            os = socket.getOutputStream();
            os.write("已读不回".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss!=null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
