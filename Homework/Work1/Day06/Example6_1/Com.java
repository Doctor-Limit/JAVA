package Work1.Day06.Example6_1;

/**
 * ********概述：
 */
public interface Com {
    public static final int MAX = 100;
    public abstract void on();
    public abstract float sum(float x, float y);
    default int max(int a, int b) {
        outPutJava();
        return a > b ? a : b;
    }
    public static void f() {
        System.out.println("注意是从JavaSE 8 开始的");
    }
    private void outPutJava() {
        System.out.println("Java");
    }
}
