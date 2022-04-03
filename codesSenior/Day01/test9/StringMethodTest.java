package Day01.test9;

import org.junit.jupiter.api.Test;

/**
 * ********概述：一般给出索引遵循左闭右开原则
 *
 */
public class StringMethodTest {

    @Test
    public void test4(){
        String s1="啊对对对";
        String s2=s1.replace("对","错");//所有原字符串存在的元素都会改变
        System.out.println(s2);
        String s3="12hello34world5java789mysql456";
        //将所有整形数据部分(\d)替换为逗号   (\d+)：可能存在多个数字   若开头或结尾有逗号则去掉(替换为空) ^:开头 $：结尾
        String s4=s3.replaceAll("\\d+",",").replaceAll("^,|,$","");
        //同理只替换第一个
        String s5=s3.replaceFirst("\\d+",",").replaceAll("^,|,$","");
        System.out.println(s4);
        System.out.println(s5);

        String s6="12345";
        boolean matches=s6.matches("\\d+");//判定字符串中是否全由数字组成，有1-n个数字组成
        System.out.println(matches);
        String tel="0571-4534289";
        boolean result=tel.matches("0571-\\d{7,8}");//判定：是否0571开头，后面有7~8位数字
        System.out.println(result);

        String s7="hello|world|java";
        String[] strs1=s7.split("\\|");//以"|"分割
        for(int i=0;i<strs1.length;i++){
            System.out.println(strs1[i]);
        }
        String s8="hello.world.java";
        String[] strs2=s8.split("\\.");//以"."分割
        for(int i=0;i<strs2.length;i++){
            System.out.println(strs2[i]);
        }
    }

    @Test
    public void test3(){
        String s1="helloworld";
        boolean b1=s1.endsWith("rld");//确定是否为其中字符串结尾
        System.out.println(b1);
        boolean b2=s1.startsWith("He");//区分大小写
        System.out.println(b2);
        boolean b3=s1.startsWith("ll",2);//从二号索引是否以当前字符串开头
        System.out.println(b3);

        String s2="wor";
        System.out.println(s1.contains(s2));//判定s1字符串中是否包含s2
        System.out.println(s1.indexOf("lol"));//若存在则返回最开头字母索引，若不存在则返回-1
        System.out.println(s1.indexOf("lo",5));//从给出的索引位置往后找，看是否找到

        String s3="hellorworld";
        System.out.println(s1.indexOf(""));//表示结尾或开头
        System.out.println(s1.indexOf("h"));
        System.out.println(s1.lastIndexOf(""));
        System.out.println(s1.lastIndexOf("d"));
        System.out.println(s3.lastIndexOf("or"));//返回的索引依旧为从前往后的索引,只不过是从后往前找
        System.out.println(s3.indexOf("or"));
        System.out.println(s3.lastIndexOf("or",6));//从索引为6从右往左找
        //当只存在唯一的字符串或不存在时，index()与lastindexof()返回值相同

    }

   @Test
   public void test2(){

       String s1="HelloWorld";
       String s2="helloworld";
       System.out.println(s1.equals(s2));
       System.out.println(s1.equalsIgnoreCase(s2));//忽略字符串大小写比较是否相等

       String s3="abc";
       String s4=s3.concat("def");//字符串的连接
       System.out.println(s4);

       String s5="abc";
       String s6=new String("abe");
       System.out.println(s5.compareTo(s6));//字符串中元素会转化为ASCII码-->字符串排序
       String  s7="啊对对对";
       String s8=s7.substring(1);//从当前索引开始，包括当前这个
       System.out.println(s7);
       System.out.println(s8);

       //左闭右开 [0,2)
       String s9=s7.substring(0,2);//从当前索引开始，到末尾索引结束，包括开始索引，不包括截止索引
       System.out.println(s9);
   }

    @Test
    public void test1(){
        String s1="HelloWorld";
        System.out.println(s1.length());//字符串长度
        System.out.println(s1.charAt(0));//字符数组中元素
        System.out.println(s1.isEmpty());//辨别是否为空  空格也算元素
        String s2=s1.toLowerCase();//字母小写
        System.out.println(s1);//s1不可变，仍为原来字符串
        System.out.println(s2);
        String s3="  hello  wo  r ld  ";
        String s4=s3.trim();//删除首尾的空格，中间存在的空格不变
        System.out.println(s3);
        System.out.println(s4);
    }
}
