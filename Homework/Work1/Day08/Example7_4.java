package Work1.Day08;

/**
 * ********概述：
 */

interface SpeakHello1 {
    void speak();
}

class HelloMachine1 {
    public void turnOn(SpeakHello1 hello) {
        hello.speak();
    }
}

public class Example7_4 {
    public static void main(String[] args) {
        HelloMachine1 machine = new HelloMachine1();
        machine.turnOn(()->{
            System.out.println("hello,you're welcome!");
        });
        machine.turnOn(()-> {
            System.out.println("你好，欢迎光临!");
        });
    }
}
