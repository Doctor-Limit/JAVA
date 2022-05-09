package Work.homework7;

/**
 * ********概述：
 */
public class Cat extends Animal{
    @Override
    public void cry() {
        System.out.println("喵喵喵");
    }

    @Override
    public String getAnimalName() {
        return "猫";
    }
}
