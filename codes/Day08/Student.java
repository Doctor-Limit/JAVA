package Day08;

public class Student extends Person {
String major;
int id=1002;//学号
public Student(){
}
public Student(String major){
   this.major=major;
}
public Student(String name,int age,String major){
    super(name,age); //调用父类中对应该形参列表的构造函数
    this.major=major;
}
public void eat(){
    System.out.println("学生多吃有营养食品");
}
public void study(){
    System.out.println("学生学习知识");
    eat();
    super.eat();
}
public void show(){
    System.out.println("name:"+this.name+",age="+super.age);
    System.out.println("id="+id);//默认为this.id 即当前子类中的id
    System.out.println("id="+super.id);//在子类中同标识符去调用父类的属性
}
}
