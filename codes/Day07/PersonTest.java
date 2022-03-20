package Day07;


//方法的重写：子类在继承父类后，可对父类中同名同参数的方法进行覆盖操作
public class PersonTest {
    public static void main(String args[]){
        Student s=new Student("计算机科学与技术");
        s.eat();
        s.walk(100);

        s.study();

    }
}
