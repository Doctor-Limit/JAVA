package Day01.test10;

import org.junit.jupiter.api.Test;

/**
 * ********概述：StringBuffer与StringBuilder功能基本相同
 *
 * 增:append(xxx);
 * 删:delete(int start,int end);
 * 改:setCharAt(int n,char ch)/replace(int start,int end,String str)
 * 查:charAt(int n)
 * 插:insert(int offset,xxx)
 * 长度:length();
 * 遍历:for+charAt()/toString
 *
 */
public class StringBufferTest {
    //效率从高到低：StringBuilder->StringBuffer->String
    @Test
    public void test2(){
        //初始设置
        long startTime=0l;
        long endTime=0l;
        String text="";
        StringBuffer buffer=new StringBuffer("");
        StringBuilder builder=new StringBuilder("");
        //开始对比
        startTime=System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));//添加基本数据类型
        }
        endTime=System.currentTimeMillis();
        System.out.println("StringBuffer执行时间："+(endTime-startTime));

        startTime=System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime=System.currentTimeMillis();
        System.out.println("StringBuilder执行时间："+(endTime-startTime));

        startTime=System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
           text+=i;
        }
        endTime=System.currentTimeMillis();
        System.out.println("String执行时间："+(endTime-startTime));
    }

    @Test
    public void test1(){

        StringBuffer s1=new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
       // s1.delete(2,4);//默认索引左闭右开
        //s1.insert(2,false);//插入元素在索引为2的位置
        //s1.replace(2,4,"hello");
      //  s1.reverse();
        System.out.println(s1);
        System.out.println(s1.length());//
        String s2=s1.substring(1,3);
        System.out.println(s2);
    }
}
