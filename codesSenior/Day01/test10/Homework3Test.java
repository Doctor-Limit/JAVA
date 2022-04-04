package Day01.test10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * ********概述：
 */
public class Homework3Test {

    public String getMaxSameString(String str1,String str2){
        if(str1!=null&&str2!=null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();
            for (int i = 0; i < length; i++) {
                //每减少一位就有多种情况，再将从0开始的字符串依次往后挪进行比较
                for (int x = 0, y = length - i; y <= length; x++, y++) {//从长到短开始找，依次往后错位
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) return subStr;
                }
            }
        }
        return null;
    }
    public String[] getMaxSameString1(String str1,String str2){
        if(str1!=null&&str2!=null){
            StringBuffer sBuffer=new StringBuffer();
            String maxString=(str1.length()>=str2.length())?str1:str2;
            String minString=(str1.length()<str2.length())?str1:str2;
            int length=minString.length();
            for(int i=0;i<length;i++){
                for(int x=0,y=length-i;y<=length;x++,y++){
                    String substring=minString.substring(x,y);
                   if(maxString.contains(substring))sBuffer.append(substring+",");
                }
                if(sBuffer.length()!=0)break;
            }
            String[] spilt=sBuffer.toString().replaceAll(",$","").split("\\,");
            return  spilt;
        }
        return null;
    }

    @Test
    public void test1(){
    String str1="abdheellhelloworldlld";
    String str2="lhelloefaoworld";
    String str3=getMaxSameString(str1,str2);
    System.out.println(str3);
    String []str4=getMaxSameString1(str1,str2);
    System.out.println(Arrays.toString(str4));
    }
}
