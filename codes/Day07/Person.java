package Day07;

public class Person {
String name;
int age;
public Person(){
}
public Person(String name,int age){
    this.name=name;
    this.age=age;
}
public void eat(){
    System.out.println("�ɷ�");
}
public void walk(int distance){
    System.out.println("��·���ߵľ����ǣ�"+distance+"����" );
}
}
