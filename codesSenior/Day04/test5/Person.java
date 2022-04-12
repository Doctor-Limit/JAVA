package Day04.test5;

/**
 * ********概述：
 */
public class Person {
    private String name;
    public int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public Person(){
    }

    private Person(String name){
        this.name=name;
    }

    public Person(String name,int age){
        this.age=age;
        this.name=name;
    }

    public void show(){
        System.out.println("我是kamida");
    }
    private String showNation(String nation){
        System.out.println("国籍为:"+nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
