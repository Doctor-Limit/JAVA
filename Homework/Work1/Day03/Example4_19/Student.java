package Work1.Day03.Example4_19;

/**
 * ********������
 */
public class Student {
    private int age;

    public void setAge(int age) {
       if(age>7&&age<=28)
           this.age=age;
    }

    public int getAge() {
        return age;
    }
}
