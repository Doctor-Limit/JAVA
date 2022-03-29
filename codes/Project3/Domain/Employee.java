package Project3.Domain;

public class Employee implements Equipment{
    private int id;
    private String name;
    private int age;
    private double salary;

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Employee(){
    }
    public Employee(int id,String name,int age,double salary){
        this.id=id;
        this.salary=salary;
        this.name=name;
        this.age=age;
    }

    public String getDetails(){
        return id+"\t"+name+"\t\t"+age+"\t\t"+salary+"\t";
    }
    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
