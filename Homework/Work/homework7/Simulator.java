package Work.homework7;

/**
 * ********概述：
 */
public class Simulator {
    public void playSound(Animal animal) {
        animal.cry();
        System.out.println(animal.getAnimalName());
    }
}
