package Day03.test10;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Locale;

/**
 * ********概述：
 *
 * 标准输入、输出流
 * 打印流: setOut（更改打印输出的位置）  默认在控制台输出
 * 数据流:只能操作基本数据类型，无法操作对象
 *
 *
 *
 */
public class OtherStreamTest {

    /*
    标准输入输出流

    使用System.in实现从键盘写入数据
    System.in--->转换流--->BufferedReader的ReadLine()  代表一行结束

     */
    @Test
    public void test1(){
        BufferedReader br=null;
        try {
            InputStreamReader isr=new InputStreamReader(System.in);
            br=new BufferedReader(isr);
            while (true){
                System.out.println("请输入字符串：");
                String str=br.readLine();
                if("e".equalsIgnoreCase(str)||"exit".equalsIgnoreCase(str)){
                    System.out.println("程序结束");
                    break;
                }
                String s = str.toUpperCase(Locale.ROOT);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //将内存中的字符串，基本上数据类型变量写出到文件中
    //数据流文件不可直接读，应用对应的数据流去读
    @Test
    public void test2() throws Exception{

        DataOutputStream dos=new DataOutputStream(new FileOutputStream("E:\\chap\\codesSenior\\Day03\\test10\\hello.txt"));
        dos.writeUTF("what");
        dos.flush();//刷新操作：将已有的数据写入文件
        dos.writeInt(486);
        dos.writeBoolean(true);
        dos.flush();
        dos.close();

    }

    //将文件中的数据读取到字符中，保存在变量中
    //读取的顺序应当与写入的顺序一致
    @Test
    public void test3() throws Exception{
        DataInputStream dis=new DataInputStream(new FileInputStream("E:\\chap\\codesSenior\\Day03\\test10\\hello.txt"));
        String s = dis.readUTF();
        int i = dis.readInt();
        boolean b = dis.readBoolean();
        System.out.println(s+i+b);
        dis.close();

    }

}
