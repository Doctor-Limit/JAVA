package Day05.test3;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * ********概述：
 *
 * 为了在程序中避免出现空指针异常而创建Optional类
 *
 *
 */
public class OptionalTest {

    /*
    Optional.of(T t):创建一个Optional实例，t必须非空
    Optional.empty():创建一个空的Optional实例
    Optional.ofNullable(T t):t可以为null
     */
    @Test
    public void test1(){
        Girl girl=new Girl();
        //of(T t):保证T非空
        Optional<Girl> girl1 = Optional.of(girl);
        Girl girl4 = girl1.orElse(new Girl("Lili"));//不为空则返回之前的对象
        System.out.println(girl4);

        girl=null;
        //ofNullable(T t):t可以为null
        Optional<Girl> girl2 = Optional.ofNullable(girl);
        //orElse(T t1):若当前的Optional内部封装的t是非空的，则返回当前内部t
        //若当前内部t为空，则返回orElse()方法中的t1
        Girl girl3 = girl2.orElse(new Girl("Alice"));//包装类对象若为空则返回后面的对象
        System.out.println(girl3);

    }
    //可能产生空指针的方法
    public String getGirlName(Boy boy){
        return boy.getGirl().getName();//会空指针
    }

    //优化后的方法
    public String getGirlName1(Boy boy){
        if(boy!=null){
            if(boy.getGirl()!=null)
                return boy.getGirl().getName();
        }
        return null;
    }

    //使用Optional类的getGirlName()
    public String getGirlName2(Boy boy){
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        //此时boy2一定非空
        Boy boy2 = boy1.orElse(new Boy(new Girl("kk")));

        Girl girl = boy2.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        //此时girl2一定非空
        Girl girl2 = girl1.orElse(new Girl("ll"));

        return girl2.getName();
    }

    @Test
    public void test2(){
        Boy boy=null;
        boy=new Boy();
        System.out.println(getGirlName2(boy));

    }

}
