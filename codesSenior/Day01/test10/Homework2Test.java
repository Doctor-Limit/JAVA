package Day01.test10;

import org.junit.jupiter.api.Test;

/**
 * ********概述：
 *
 */
public class Homework2Test {

public int getCount(String mainStr,String subStr){//获取子字符串(subStr)在主字符串(mainStr)出现的次数
   int mainLength=mainStr.length(),subLength=subStr.length();
   if(mainLength<subLength)return 0;
   if(mainLength==subLength)return mainStr.equals(subStr)?1:0;
    int index=0,count=0;
    if(mainStr.startsWith(subStr))count++;
    while(index>=0){
        index=mainStr.indexOf(subStr,index+subStr.length());
        if(index>=0)count++;
    }
    return count;
}

@Test
    public void test1(){
    String s2="abkkcadkabkebfkabkkskab";
    String s3="kksk ";
    int count=getCount(s2,s3);
    System.out.println(count);
}

    @Test
    public void test2(){
    label:    for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j ==1) break label;
                System.out.println(i+" "+j);
            }
        }
    }
}
