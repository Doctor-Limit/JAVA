package Day07;
/*

方法的声明：权限修饰符 返回值类型 方法名(形参列表) throws 异常的类型{
           方法体
}
方法的重写：子类在继承父类后，可对父类中同名同参数的方法进行覆盖操作
两方法的方法名与形参列表相同，子类重写的权限不小于父类中被重写方法
子类不能重写父类中权限为private的方法(不认为是重写)
父类返回值类型是void，则子类也要为void
父类被重写的返回值类型为A类型，则子类重写方法的返回值类型可以是A类或A类的子类
父类被重写的返回值类型为基本数据类型，则子类重写方法的返回值类型必须是相同的基本数据类型
子类重写方法输出的异常类型不大于父类被重写方法输出的异常类型

子类和父类中同名同参数的方法必须同时为static(不叫重写)或同时为非static(考虑重写)

*/
//权限级别：private (缺省) protected public
//private void get()-->void get()-->protected void get()-->public void get()
//在不同包的子类中，不能访问缺省与私有权限，仅可访问保护及公开
//不同包的非子类无法访问保护、缺省及私有，仅能访问公开

public class PersonTest {
    public static void main(String args[]){
        Student s=new Student("计算机科学与技术");
        s.eat();
        s.walk(100);

        s.study();

    }
}
