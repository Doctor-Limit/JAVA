package Day02.test3;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * ********概述：其他类的使用
 * 1、system
 * 2、Math
 * 3、BigInteger和BigDecimal
 *    任意长度     任意精度
 */
public class OtherClassTest {

    @Test
    public void test1(){

        BigInteger bi=new BigInteger("1243");
        BigDecimal bd1=new BigDecimal("123.43");
        BigDecimal bd2=new BigDecimal("11");
        System.out.println(bd1.divide(bd2, RoundingMode.HALF_UP));
        System.out.println(bd1.divide(bd2,15,RoundingMode.HALF_UP));//保留15位
    }
}
