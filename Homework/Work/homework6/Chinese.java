package Work.homework6;

/**
 * ********概述：
 */
public class Chinese extends Person{

    public Chinese(){
    }
    public void chinaGongFu(){
        System.out.println("中国功夫");
    }

    @Override
    public void speakHello() {
        System.out.println("中国hello");
    }

    @Override
    public void averageHeight() {
        System.out.println("中国身高");
    }

    @Override
    public void averageWeight() {
        System.out.println("中国重量");
    }
}
