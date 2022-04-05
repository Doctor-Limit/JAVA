package Day02.test4;

/**
 * ********概述：使用enum关键字定义枚举类
 *
 * 定义的枚举类默认继承 java.lang.Class类
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(Season1.class.getClass());

        //valueOf：返回枚举类中对象名是objName的对象
        //若没有objName的枚举类对象，则抛异常
        Season1 spring = Season1.valueOf("SPRING");
        System.out.println(spring);
        spring.show();

    }
}

interface Info{
    void show();
}

enum Season1 implements Info{
    //提供当前枚举类的对象，多个对象间逗号隔开，末尾对象分号结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("梅");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("兰");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("竹");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("菊");
        }
    } ;

    private final String seasonName;
    private final String seasonDesc;

     Season1(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

//    @Override
//    public void show() {
//        System.out.println("季节");
//    }
}