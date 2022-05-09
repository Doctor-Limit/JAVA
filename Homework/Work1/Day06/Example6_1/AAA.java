package Work1.Day06.Example6_1;

/**
 * ********概述：
 */
public class AAA implements Com{
    @Override
    public void on() {
        System.out.println("打开电视");
    }

    @Override
    public float sum(float x, float y) {
        return x + y;
    }
}
