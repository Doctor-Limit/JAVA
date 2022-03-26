package Day11.test4;

//对象+instanceof+类型，判断该对象是否为该类或父类创建
import org.junit.Test;

public class InterviewTest {
    @Test
    public void test1(){
//      Object o1=true?new Integer(1):new Double(2.0);  三目运算符只有在类型相等的情况下才能比较，故int类型会自动提升为double类型
//      System.out.println(o1);输出结果为1.0
    }

    @Test
    public void test2(){
//      Object o2;  类型不会自动进行改变
//      if(true) o2=new Integer(1);
//      else o2=new Double(2.0);
//      System.out.println(o2);输出结果为1
    }


    //Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
    //保存了从-128~127之间的整数，若使用自动装箱方式，给Integer赋值的范围在
    //-128~127之间，可以直接使用数组中元素，不需要新建，提高效率  ==》在范围内，值相同则引用相同


    @Test
    public void test3(){
//        Integer i=new Integer(1);
//        Integer j=new Integer(1);
//        System.out.println(i==j);false 地址不同，不是同一对象

        //int型值在-128~127之间若两者数值相同则指向同一地址，若不在其中，就需要新建对象来存储
        Integer m=1;
        Integer n=1;
        System.out.println(m==n); //true 在取值范围内且值相同，则默认两者指向同一地址

        Integer x=128;
        Integer y=128;
        System.out.println(x==y); //false new了两个值为128的对象，所以地址不同
    }

}
