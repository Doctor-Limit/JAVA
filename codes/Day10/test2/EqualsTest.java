package Day10.test2;


//**************  ==与equals()区别
/*
一、  ==的使用
1、使用在基本数据类型和引用变量类型
2、若比较的为基本数据类型变量，比较两变量数据是否相同  例：(char)"A"==65(int) true
   若比较的为引用数据类型变量，比较两对象地址值是否相同，即两引用是否指向同一对象实体

二、  equals()方法的引用
1、方法而非运算符
2、只适用于引用数据类型
3、Object类中equals()的定义：
    public boolean equals(Object obj){
    return (this==obj);
    }
    说明：Object类中定义equals()与==作用相同
4、像String Data File 包装类都重写了Object中的equals()方法，重写后比较的不是两引用
   而是实例对象中的内容是否相同




 */
public class EqualsTest {
    public static void main(String[] args) {



    }




}
