package Day07;

public class Student extends Person{
    String major;
    public Student(){
    }
    public Student(String major){
        this.major=major;
    }
    public void study(){
        System.out.println("学习专业是："+major);
    }
    public void eat(){ //子类中叫重写方法，父类叫被重写方法
        System.out.println("学生应该多吃有营养的食物");
    }

}
