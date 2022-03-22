package Day09;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test=new AnimalTest();
        test.func(new Dog());

        test.func(new Cat());//运用子类的对象






    }

    public void func(Animal animal){  //本质  Animal animal1=new Dog();
        animal.eat();
        animal.shout();

    }

}
class Animal{
    public void eat(){
        System.out.println("动物进食");
    }
    public void shout(){
        System.out.println("动物叫");
    }
}
class Dog extends Animal{
    public void eat(){
        System.out.println("狗啃骨头");
    }
    public void shout(){
        System.out.println("汪汪汪");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void shout(){
        System.out.println("喵喵喵");
    }
}








