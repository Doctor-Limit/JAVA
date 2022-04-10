package Day03.test10;

import java.io.Serializable;

/**
 * ********概述：
 *
 * 满足以下要求才可序列化：
 * 1、需要实现Serializable接口
 * 2、需要当前类提供全局常量serialVersionUID==》确保当类被修改时，依旧可以反序列化成修改后类
 * 3、除了当前类需要实现可序列化接口外，还必须保证其内部所有属性也要可序列化
 *    默认情况下，基本数据类型可序列化
 *
 * 序列化机制：
 * 对象序列化允许把内存中java对象转化为与平台无关的二进制码，允许把二进制流保存在磁盘上
 * 或通过网络将这种二进制传输到另一个网络节点，当其他程序获取了这种二进制流，就可恢复为原来java对象
 *
 * 不能序列化static和transient的成员变量 无法在外部对默认值进行修改
 *
 *
 *
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 43462412445332L;
    private String name;
    private  int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person(){
    }

    public Person(String name,int age){
        this.age=age;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
