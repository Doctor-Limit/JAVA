package Work.homework9;

import Work.homework7.Cat;
import Work.homework7.Dog;
import Work.homework7.Simulator;

/**
 * ********概述：
 */
public class Application {
    public static void main(String[] args) {
        Work.homework7.Simulator simulator = new Simulator();
        simulator.playSound(new Dog());
        simulator.playSound(new Cat());
    }
}
