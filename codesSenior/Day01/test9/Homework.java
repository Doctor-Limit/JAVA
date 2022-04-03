package Day01.test9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * ********概述：
 */


public class Homework {
    public static char[] trim(char[] chars){
        char[] chars1=new char[chars.length];
        int index = 0,count=0;
        for (char aChar : chars) {
            if (aChar != ' ') chars1[index++] = aChar;
            else if(aChar==' ')count++;
        }
        char[] chars2=new char[chars.length-count];
        for (int i = 0; i < chars.length-count; i++) {
            chars2[i]=chars1[i];
        }
        return chars2;
    }

    public static void main(String[] args) {
        char c[]=new char[]{' ','h','e','l',' ','l','o',' ',' ','y','o','u',' '};
        c=trim(c);
        String s1=new String(c);
        System.out.println(s1);

        String s2="abkkcadkabkebfkabkkskab";
        String s3="ab";
        int index=0,count=0;
        while(index>=0){
            index=s2.indexOf(s3,index+s3.length());
            if(index>0)count++;
        }
        System.out.println(count);
    }
}
