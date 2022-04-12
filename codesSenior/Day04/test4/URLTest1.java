package Day04.test4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ********概述：
 *
 */
public class URLTest1 {
    public static void main(String[] args){
        HttpURLConnection urlConnection=null;
        InputStream is=null;
        FileOutputStream fos=null;
        try {
            URL url=new URL("https://www.baidu.com/baidu?tn=monline_7_dg&ie=utf-8&wd=%E7%99%BE%E5%BA%A6");
            urlConnection= (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos=new FileOutputStream("E:\\chap\\codesSenior\\Day04\\test4\\hello.txt");
            byte[] bytes=new byte[1024];
            int len;
            while ((len=is.read(bytes))!=-1){
                fos.write(bytes,0,len);
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
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(urlConnection!=null)
            urlConnection.disconnect();
        }
    }
}
