package Day09;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test=new AnimalTest();
        test.func(new Dog());

        test.func(new Cat());//��������Ķ���






    }

    public void func(Animal animal){  //����  Animal animal1=new Dog();
        animal.eat();
        animal.shout();

    }

}
class Animal{
    public void eat(){
        System.out.println("�����ʳ");
    }
    public void shout(){
        System.out.println("�����");
    }
}
class Dog extends Animal{
    public void eat(){
        System.out.println("���й�ͷ");
    }
    public void shout(){
        System.out.println("������");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("è����");
    }
    public void shout(){
        System.out.println("������");
    }
}








