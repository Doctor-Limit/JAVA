package Day11.test2;

import java.util.Date;

import static org.junit.Assert.*;

/*
 ************Java�е�JUnit��Ԫ����
 *
 *1��Java��Ҫ��:������public   �����ṩ�������޲εĹ�����
 *
 *2�� ������������Ԫ���Է���������Ȩ��Ϊpublic���޷���ֵ��û���β�
 *3���˵�Ԫ���Է�������Ҫ����ע�⣬@Test,�������Ӧ��
 *
 *
 *
 *
 */
public class JUnitTestTest {

    @org.junit.Test
    public void testEquals() {
        String s1="MM";
        String s2="MM";
        System.out.println(s1.equals(s2));

//
//        Object obj=new String("GG");
//        Date date=(Date) obj;


    }
}