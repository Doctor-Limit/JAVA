package Day04.test2;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ********概述：
 * 客户端发送文件到服务端，服务端将文件保存至本地
 *
 */
public class TCPTest2 {

    @Test
    public void client() {

        Socket socket=null;
        OutputStream os=null;
        FileInputStream fis=null;
        try {
            InetAddress ine1=InetAddress.getByName("127.0.0.1");
            socket=new Socket(ine1,666);
            os=socket.getOutputStream();
            fis=new FileInputStream(new File("E:\\chap\\codesSenior\\Day04\\test2\\1.jpg"));
            byte[] bytes=new byte[1024];
            int len;
            while ((len=fis.read(bytes))!=-1){
                os.write(bytes,0,len);
            }

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
        }
    }

    @Test
    public void Server() {

        ServerSocket ss=null;
        Socket socket=null;
        InputStream is=null;
        FileOutputStream os=null;
        try {
            ss=new ServerSocket(666);
             socket = ss.accept();
             is=socket.getInputStream();
            File file=new File("E:\\chap\\codesSenior\\Day04\\test2\\2.jpg");
            os=new FileOutputStream(file);
            byte[] bytes=new byte[1024];
            int len;
            while ((len=is.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
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
