package Work.homework6;

/**
 * ********概述：
 */
public class American extends Person{

    public American(){
    }
    public void americanBoxing(){
        System.out.println("盒子");
    }

    @Override
    public void averageWeight() {
        System.out.println("美国人重量");
    }

    @Override
    public void averageHeight() {
        System.out.println("美国人身高");
    }

    @Override
    public void speakHello() {
        System.out.println("美国人hello");
    }
}
