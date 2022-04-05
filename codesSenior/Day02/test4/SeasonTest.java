package Day02.test4;

/**
 * ********概述：枚举类的使用
 * 1、当一个1类的对象只有有限个，确定的，我们称此类为枚举类
 * 2、当需要定义一组常量时，建议使用枚举类
 * 3、若枚举类中仅存在一个对象，则可以作为单例模式的实现方式
 *
 * 如何定义枚举类？
 * 一：jdk5.0之前，自定义枚举类
 * 二：jdk5.0，使用enum关键字定义类
 *
 * ENUM类中常用方法
 *
 *  values():返回枚举类型对象数组，可遍历所有枚举值
 *  valuesOf():把一个字符串转为对应的枚举类对象，要求字符串必须是枚举类对象
 *  toString():返回当前枚举类对象常量的名称
 *
 *
 * 使用enum关键字实现接口
 *  1、在enum类中实现抽象方法
 *  2、让枚举类的对象分别实现抽象方法
 *
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season winter = Season.WINTER;
        System.out.println(winter);
    }
}

class Season{
    //声明Season对象的属性不可变
    private final String seasonName;
    private final String seasonDesc;

    //私有化类的构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    //提供当前枚举类的多个对象 public static final
    public static final Season SPRING=new Season("春天","春暖花开");
    public static final Season SUMMER=new Season("夏天","夏日炎炎");
    public static final Season AUTUMN=new Season("秋天","秋高气爽");
    public static final Season WINTER=new Season("冬天","冰天雪地");

    //其他诉求:获取属性
    public String getSeasonDesc() {
        return seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}