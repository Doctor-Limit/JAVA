package Work.homework9;

import Work.homework7.Animal;

/**
 * ********概述：
 */
public class Cat extends Animal {
    @Override
    public void cry() {
        System.out.println("喵喵喵");
    }

    @Override
    public String getAnimalName() {
        return "猫";
    }
}
