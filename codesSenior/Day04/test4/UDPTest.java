package Day04.test4;

import org.junit.jupiter.api.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * ********概述：UDP协议的网络编程
 * 快速转发，不对数据进行检验操作
 *

 */
public class UDPTest {

    //发送端
    @Test
    public void client() throws Exception{
        DatagramSocket socket = new DatagramSocket();

        String str="UDP方式封装数据报";
        byte[] data=str.getBytes();
        InetAddress ine1=InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,ine1,666);

        socket.send(packet);
        socket.close();

    }

    //接收端
    @Test
    public void Server() throws Exception{
        DatagramSocket socket = new DatagramSocket(666);
        byte[] bytes=new byte[1025];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();

    }

}
