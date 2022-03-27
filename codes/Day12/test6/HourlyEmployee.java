package Day12.test6;

public class HourlyEmployee extends Employee{
    private double wage;//每小时工资
    private double hour;

    public void setHour(double hour) {
        this.hour = hour;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHour() {
        return hour;
    }

    public double getWage() {
        return wage;
    }

    @Override
    public double earnings() {
        return wage*hour;
    }
    @Override
    public String toString() {
        return "HourlyEmployee{" + super.toString()+ '}';
    }
    public HourlyEmployee(){
    }
    public  HourlyEmployee(String name,int number,MyDate birthday ){
        super(name, number, birthday);
    }
    public  HourlyEmployee(String name,int number,MyDate birthday,double wage,double hour){
        super(name, number, birthday);
        this.hour=hour;
        this.wage=wage;
    }
}
