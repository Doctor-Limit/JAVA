package Work.homework6;

/**
 * ********概述：
 */
public class Beijingman extends Chinese{
    public Beijingman(){
    }

    public void beijingPera(){
        System.out.println("北京烤鸭");
    }

    @Override
    public void speakHello() {
        System.out.println("北京hello");
    }

    @Override
    public void averageHeight() {
        System.out.println("北京身高");
    }

    @Override
    public void averageWeight() {
        System.out.println("北京重量");
    }
}
