package Day04.test2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * ********概述：实现TCP的网络编程
 *
 * 客户端发送数据到服务端，服务端显示在控制台中
 *
 *
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client(){

        OutputStream os=null;
        Socket socket=null;
        try {
            //创建Socket对象，指明服务器端Ip及端口号
            InetAddress inet1=InetAddress.getByName("127.0.0.1");
            socket=new Socket(inet1,666);
            //获取输出流，用于输出数据
            os=socket.getOutputStream();
            //写出数据的操作
            os.write("客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
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
        }
    }

    //服务端
    @Test
    public void server() {

        //创建服务器端ServerSocket，指定端口号
        ServerSocket ss=null;
        Socket socket=null;
        InputStream is=null;
        ByteArrayOutputStream baos=null;
        try {
            ss = new ServerSocket(666);
            //调用此方法表示来自于客户端Socket
           socket = ss.accept();
           //获取输入流数据
            is = socket.getInputStream();
            //可能会导致乱码，一个汉字三个字节，可能非整数倍无法还原
//        byte[] bytes=new byte[1024];
//        int len;
//        while ((len=is.read(bytes))!=-1){
//            String str=new String(bytes,0,len);
//            System.out.print(str);
//        }

           //读取输入流的数据
           baos=new ByteArrayOutputStream(); //不会直接拼接字节数组，而是全部接收完后在总体拼接
            byte[] bytes=new byte[1024];
            int len;
            while ((len=is.read(bytes))!=-1){
               baos.write(bytes,0,len);
            }
            System.out.print(baos.toString());
            System.out.println("收到来自于"+socket.getInetAddress().getHostAddress()+"的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(baos!=null) {
                try {
                    baos.close();
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
        }
    }
}
