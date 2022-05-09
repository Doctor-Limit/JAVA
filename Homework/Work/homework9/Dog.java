package Work.homework9;

import Work.homework7.Animal;

/**
 * ********概述：
 */
public class Dog extends Animal {
    @Override
    public void cry() {
        System.out.println("汪汪汪");
    }

    @Override
    public String getAnimalName() {
        return "狗";
    }
}
