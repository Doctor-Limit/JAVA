package Work1.Day04;

/**
 * ********概述：
 */
class People{
    private int getAverHeight=166;
    public int getGetAverHeight(){
        return getAverHeight;
    }
}
class ChinaPeople extends People{
    int height;

    public void setHeight(int h) {
        height = h;
    }

    public int getHeight() {
        return height;
    }
}

public class Example5_2 {
    public static void main(String[] args) {
        ChinaPeople zhangSan=new ChinaPeople();
        System.out.println("子类对象未继承的averHeight的值时："+zhangSan.getGetAverHeight());
        zhangSan.setHeight(178);
        System.out.println("子类对象的实例变量height值是："+zhangSan.getHeight());
    }

}
