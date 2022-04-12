package Day04.test5;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * ********概述：
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        //对于自定义类，使用系统加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器的getParent（）：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();//该类的上一层
        System.out.println(classLoader1);

        //调用扩展类加载器的getParent（）：无法获取引导类加载器
        //引导类加载器主要负责java的核心类库，所以无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();//引导类加载器
        System.out.println(classLoader2);

    }

    //Properties:获取配置文件
    @Test
    public void test2() throws Exception{

        Properties pros=new Properties();
//        //此时该文件默认为Module下  方式一
//        FileInputStream fis=new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //方式二：使用ClassLoader
        //配置文件默认识别为当前module的资源文件夹下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password=pros.getProperty("password");
        System.out.println("name="+user+",password="+password);

    }

}
