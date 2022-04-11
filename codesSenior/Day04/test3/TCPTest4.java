package Day04.test3;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ********概述：
 *
 * 服务器端读取图片并发送给客户端，客户端保存图片至本地
 *
 */
public class TCPTest4 {

    @Test
    public void client() throws Exception{
        InetAddress ine1=InetAddress.getByName("127.0.0.1");
        Socket socket=new Socket(ine1,666);
        InputStream fos=socket.getInputStream();
        File file = new File("E:\\chap\\codesSenior\\Day04\\test3\\2.jpg");
        FileOutputStream fs=new FileOutputStream(file);
        byte[] bytes=new byte[1024];
        int len;
        while ((len=fos.read(bytes))!=-1){
            fs.write(bytes,0,len);
        }
        System.out.println("保存成功");

        fs.close();
        fos.close();
        socket.close();
    }

    @Test
    public void Server() throws Exception{
        ServerSocket ss=new ServerSocket(666);
        Socket socket = ss.accept();
        OutputStream os=socket.getOutputStream();
        FileInputStream fos=new FileInputStream(new File("E:\\chap\\codesSenior\\Day04\\test2\\1.jpg"));
        byte[] bytes=new byte[1024];
        int len;
        while ((len=fos.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        fos.close();
        os.close();
        socket.close();
        ss.close();

    }

}
