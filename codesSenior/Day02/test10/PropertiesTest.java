package Day02.test10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ********概述：
 */
public class PropertiesTest {

    //Properties处理配置文件
    public static void main(String[] args) {

        FileInputStream fis= null;
        try {
            Properties pros=new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载对应文件
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println(name+" "+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null)
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
