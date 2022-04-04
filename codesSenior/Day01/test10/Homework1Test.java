package Day01.test10;

import org.junit.jupiter.api.Test;

/**
 * ********概述：
 */
public class Homework1Test {
    //方式一：转换为char[]
    public String reverse(String str,int startIndex,int endIndex){
        if(str!=null){
            char[] arr=str.toCharArray();
            for(int x=startIndex,y=endIndex;x<y;x++,y--){
                char temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二：使用String拼接操作
    public String reverse1(String str,int startIndex,int endIndex){
        if(str!=null) {
            String reverseStr = str.substring(0, startIndex);//第一部分：反转字符串之前的字符串
            for (int i = endIndex; i >= startIndex; i--) {//第二部分：中间反转的字符串
                reverseStr += str.charAt(i);
            }
            reverseStr += str.substring(endIndex + 1);//第三部分：反转字符串之后的字符串
            return reverseStr;
        }
        return null;
    }

    //方式三：使用StringBuffer/StringBuilder替换String
    public String reverse2(String str,int startIndex,int endIndex){
        if(str!=null){
            StringBuilder builder=new StringBuilder(str.length());
            builder.append(str.substring(0,startIndex));//第一部分同理
            for (int i = endIndex; i >= startIndex; i--){
                builder.append(str.charAt(i));//就是从后面开始添加
            }
            builder.append(str.substring(endIndex));
            return  builder.toString();
        }
        return null;
    }

    @Test
    public void test1(){

        String str="abcdefg";
        String reverse=reverse(str,2,5);
        System.out.println(reverse);
        String reverse1=reverse1(str,2,5);
        System.out.println(reverse1);
        String reverse2=reverse1(str,2,5);
        System.out.println(reverse2);

    }
}
