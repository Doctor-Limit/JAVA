package Day04.test2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ********概述：
 * 编程中问题：（1）如何准确定位网络上一台或多台主机，及其上的特定应用
 *           （2）找到主机后如何可靠高效的进行数据传输
 *
 * 两要素：（1）IP和端口号
 *        （2）提供网络通信协议：TCP/IP参考模型
 *
 *
 * 通信要素一：IP和端口号
 *
 * 1、IP：唯一的标识Internet上的计算机（通信实体）
 * 2、在java中使用InetAddress类代表IP
 * 3、分类：IPV4与IPV6；万维网和局域网
 * 4、域名：www+...+.com
 * 5、本地回路地址：127.0.0.1  对应Localhost
 *
 * 6、实例化InetAddress方法 （1）getName（String host） （2）getLocalHost（）
 *    getHostName（）/getAddress（）
 *
 * 7、端口号：计算机上运行的程序
 *    要求：不同的进程有不同的端口号
 *    范围：规定为16位整数：0~65535  2^16-1
 *
 * 8、端口号与IP地址的组合得出一个网络套接字：Socket
 *
 *
 */
public class InterAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1=InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet3=InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            InetAddress inet4 = InetAddress.getLocalHost();//获取本机ip
            System.out.println(inet4);

            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
