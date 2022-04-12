package Day04.test6;

/**
 * ********概述：
 *
 */

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;
    public Person(){
    }
    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name=name;
    }
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("国籍为："+nation);
        return nation;
    }

    public String display(String interests) throws NumberFormatException,NullPointerException{
        return interests;
    }

    @Override
    public void info() {
        System.out.println("人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc(){
        System.out.println("不做人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
