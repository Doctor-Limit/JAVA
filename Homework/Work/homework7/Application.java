package Work.homework7;

/**
 * ********概述：
 */
public class Application {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.playSound(new Dog());
        simulator.playSound(new Cat());
    }
}
