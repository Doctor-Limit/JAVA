package Day06;

public class Student {
    private int sex;
    private int salary;
   public void manOrwoman(int sex){
        boolean x=sex==1?true:false;
        if(x) System.out.println("man");
        else System.out.println("woman");
    }
    public void employeed(int salary){
        boolean y=salary==0?true:false;
        if(y)System.out.println("no job");
        else System.out.println("job");
    }
    public int getSex(){
        return sex;
    }
    public int getSalary(){
        return salary;
    }
    public void setSex(int sex){
        this.sex=sex;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public Student(){
    }
    public Student(int sex,int salary){
        this.sex=sex;
        this.salary=salary;
    }
}
