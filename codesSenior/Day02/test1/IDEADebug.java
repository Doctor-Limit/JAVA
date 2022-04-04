package Day02.test1;

import org.junit.jupiter.api.Test;

/**
 * ********概述：
 */
public class IDEADebug {

    @Test
    public void test1(){
        String str=null;
        StringBuffer sb=new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());// 4
        System.out.println(sb);//"null"

        StringBuffer sb1=new StringBuffer(str);//抛异常：NullPointerException
        System.out.println(sb1);

    }

}
