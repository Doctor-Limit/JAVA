package Day04.test3;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

/**
 * ********概述：
 * 客户端发送文本，服务器端将文本大写再返回给客户端
 *
 */
public class TCPTest5 {

    @Test
    public void client() throws Exception{
        InetAddress ine1=InetAddress.getByName("127.0.0.1");
        Socket socket=new Socket(ine1,666);
        OutputStream os=socket.getOutputStream();
        os.write("kzojBAUfiafHBhaifeaw".getBytes());

        socket.shutdownOutput();

        InputStream is=socket.getInputStream();
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        byte[] bytes1=new byte[1024];
        int len1;
        while ((len1=is.read(bytes1))!=-1){
            bos.write(bytes1,0,len1);
        }
        System.out.println(bos.toString());

        bos.close();
        is.close();
        os.close();
        socket.close();
    }

    @Test
    public void Server() throws Exception{
        ServerSocket ss=new ServerSocket(666);
        Socket socket=ss.accept();
        InputStream is=socket.getInputStream();
        String str=null;
        OutputStream os=socket.getOutputStream();
        byte[] bytes=new byte[1024];
        int len;
        while ((len=is.read(bytes))!=-1){
          str=new String(bytes,0,len);
        }
        os.write(str.toUpperCase(Locale.ROOT).getBytes());

        os.close();
        is.close();
        socket.close();
        ss.close();

    }
}
