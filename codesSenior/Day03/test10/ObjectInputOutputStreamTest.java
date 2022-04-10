package Day03.test10;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * ********概述：对象流的使用
 * ObjectInputStream和ObjectOutputStream
 * 作用：用于存储和读取基本类型数据或对象的处理流，可把java中的对象序列化
 *
 * java对象可序列化满足的要求：
 *
 *
 *
 */
public class ObjectInputOutputStreamTest {
    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void test1() {
        ObjectOutputStream oos=null;
        try {
            oos=new ObjectOutputStream(new FileOutputStream("Object.dat"));

            oos.writeObject(new String("kksk"));
            oos.writeObject(new Person("张三",35));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化：将磁盘文件中的对象还原为内存中一个java对象

     */
    @Test
    public void test2() {
        ObjectInputStream ois= null;
        try {
            ois=new ObjectInputStream(new FileInputStream("Object.dat"));
            Object obj=ois.readObject();
            String str=(String)obj;

            Person p= (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
