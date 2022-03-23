package Day10.test1;

//*************************多态在方法中只适用于重写，重载无法参加

//同一方法，个数更明确的优先调用

//多态实际运行时的数据还是看声明的实例对象，方法是实例对象中的方法


//仅当子类的实例对象赋给父类，该父类被强转为子类才可成功运行

//根据new的对象(实例对象)来判定是否可转化，实例对象中无对应方法就不能转化
//new子类时要加载父类，所以子类赋给父类可以

// a instanceof A  :判断对象a是否为类A的实例，若为真则返回true
//避免在向下转型时出现异常，运用instanceof返回true时则可以向下转型
public class PersonTest {
    public static void main(String[] args) {
        Person p1=new Person();
        p1.eat();
        Man m4=(Man)p1;//实际p1并未有Man中的实例化，仅存在实例化具体对象才可强转。

        Person p2=new Man();//多态
       //无法调用子类特有的子类或方法
//对象的多态性：内存中实际加载了子类特有的属性及方法，但由于声明变量为父类类型，导致编译时，只能调用父类中声明的属性及方法

          //如何调用子类特有的属性及方法

          Man m1=(Man)p2; //向下转型：使用强制类型转换符
          m1.earnMoney();
          m1.isSmoking=true;

        //仅能在子类与父类之间强转，若两子类转换则会出现ClassCastException的异常
//          Woman w1=(Woman)p2;//编译可通过,但p2并未有Woman的实例对象
//          w1.goShopping();

        if(p2 instanceof Man)System.out.println("Man");
        if(p2 instanceof Woman)System.out.println("Woman");

       // Person p3=new Woman();//编译通过但实例对象为Woman，无法强转为Man
        //Man m3=(Man)p3;

         Object obj=new Woman();
         Person p=(Person)obj;

    }
}
