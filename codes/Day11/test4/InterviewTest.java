package Day11.test4;

//����+instanceof+���ͣ��жϸö����Ƿ�Ϊ������ഴ��
import org.junit.Test;

public class InterviewTest {
    @Test
    public void test1(){
//      Object o1=true?new Integer(1):new Double(2.0);  ��Ŀ�����ֻ����������ȵ�����²��ܱȽϣ���int���ͻ��Զ�����Ϊdouble����
//      System.out.println(o1);������Ϊ1.0
    }

    @Test
    public void test2(){
//      Object o2;  ���Ͳ����Զ����иı�
//      if(true) o2=new Integer(1);
//      else o2=new Double(2.0);
//      System.out.println(o2);������Ϊ1
    }


    //Integer�ڲ�������IntegerCache�ṹ��IntegerCache�ж�����Integer[],
    //�����˴�-128~127֮�����������ʹ���Զ�װ�䷽ʽ����Integer��ֵ�ķ�Χ��
    //-128~127֮�䣬����ֱ��ʹ��������Ԫ�أ�����Ҫ�½������Ч��  ==���ڷ�Χ�ڣ�ֵ��ͬ��������ͬ


    @Test
    public void test3(){
//        Integer i=new Integer(1);
//        Integer j=new Integer(1);
//        System.out.println(i==j);false ��ַ��ͬ������ͬһ����

        //int��ֵ��-128~127֮����������ֵ��ͬ��ָ��ͬһ��ַ�����������У�����Ҫ�½��������洢
        Integer m=1;
        Integer n=1;
        System.out.println(m==n); //true ��ȡֵ��Χ����ֵ��ͬ����Ĭ������ָ��ͬһ��ַ

        Integer x=128;
        Integer y=128;
        System.out.println(x==y); //false new������ֵΪ128�Ķ������Ե�ַ��ͬ
    }

}
