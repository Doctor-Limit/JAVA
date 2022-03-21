package Day08;

public class Person {
String name;
int age;
int id=1001;//身份证号
public Person(){
}
public Person(String name){
    this.name=name;
}
public Person(String name,int age){
    this(name); //当前面已出现此声明时,等价于this.name=name;
    this.age=age;
}
public void eat(){
    System.out.println("人吃饭");
}
public void walk(){
    System.out.println("人走路");
}
}
