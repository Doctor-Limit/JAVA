package Day11.test3;

import org.junit.Test;

/*
********************��װ���ʹ�ã�
1��java�ṩ��8�ֻ����������͵İ�װ�࣬ʹ�û����������͵ı��������������(byte,short,int,long,float,double,char,boolean)
2�������������͡���װ�ࡢString����֮���໥ת��
*
 */
public class WrapperTest {

    //String����--�������������ͣ���װ��  ���ð�װ���parse()����
    @Test
    public void test6(){
         String str1="123";
         //int num1=(int)str1;  �������Ӹ����ϵ�����޷�ǿת

         int num1=Integer.parseInt(str1);
         System.out.println(num1+1);

    }

    //�����������ͣ���װ��--��String�࣬����String���ص�valueOf��������
    @Test
    public void test5(){
        int num1=10;
        String str1=num1+" "; //ֱ����������

        float f1=12.5f;
        String str2=String.valueOf(f1);//"12.6"
    }

    //JDK5.0�������ԣ��Զ�װ�����Զ�����
    @Test
    public void test4(){
        int num2=10;
        Integer in1=num2; //�Զ�װ��  ������������--����װ��

        int num1=in1;//�Զ�����  ��װ��--��������������

    }

    @Test   //����������ת��Ϊ�࣬ʵ�����ݵĶ�̬
    public void test3(){
        int num1=10;
        method(num1);
    }

    public void method(Object obj){
    }

    @Test  //������������--����װ��
    //��jdk9.0������ѱ�����
   public void test1(){
//       int num1=10;
//       Integer in1=new Integer(num1);  �����������������γ���10��װ��������
//       System.out.println(in1.toString());

       //�쳣,ֻ��Ϊһ���������
//        Integer in2=new Integer("123");
//        System.out.println(in2.toString());

       // Float f1=new Float(10.5f);

       //Boolean b1=new Boolean(true);
   }
   //��װ��--��������������
    @Test
    public void test2(){
//        Integer in1=new Integer(10);
//        int in1=in1.intValue(); ͨ������ת��Ϊ��������������ʵ�������������

    }
}
