package Day04.test4;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * ********概述：URL 网络编程
 *
 * 统一资源定位符，对应着互联网的某一资源地址
 *
 * 格式：协议  主机名  端口号  资源地址  参数列表
 *     http://192.168.10.127:6666/test4/hello.txt？userName=tom
 *
 */
public class URLTest {

    public static void main(String[] args) {
        try {
            URL url=new URL("https://www.baidu.com/baidu?tn=monline_7_dg&ie=utf-8&wd=%E7%99%BE%E5%BA%A6");
            System.out.println(url.getProtocol());//获取该URL协议名
            System.out.println(url.getHost());//该URL主机号
            System.out.println(url.getPort());//该URL端口
            System.out.println(url.getPath());//该URL文件路径
            System.out.println(url.getFile());//该URL文件名
            System.out.println(url.getQuery());//该URL查询名


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
