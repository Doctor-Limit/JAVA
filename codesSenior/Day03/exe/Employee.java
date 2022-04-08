package Day03.exe;

/**
 * ********概述：
 */
public class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Employee(String name,int age,MyDate birthday){
        this.age=age;
        this.name=name;
        this.birthday=birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public MyDate getBirthday() {
        return birthday;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee employee=(Employee) o;
            return this.name.compareTo(employee.name);
        }
        else throw new RuntimeException("输入类型不匹配");
    }

}
class MyDate{
    private int year;
    private int month;
    private int day;

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public MyDate(int year,int month,int day){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
