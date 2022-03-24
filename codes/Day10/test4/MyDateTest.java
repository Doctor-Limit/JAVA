package Day10.test4;

import java.util.Objects;

class Mydate{
    private int day;
    private int month;
    private int year;
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
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Mydate() {

    }
    public Mydate(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    @Override
    public boolean equals(Object obj) {
      if(this==obj)return true;
      if(obj instanceof Mydate){
          Mydate mydate=(Mydate) obj;
          return this.year==mydate.year&&this.day==mydate.day&&this.month==mydate.month;
      }
      return false;
    }
}
public class MyDateTest {
    public static void main(String[] args) {
        Mydate m1=new Mydate(12,3,1976);
        Mydate m2=new Mydate(15,4,1978);
        Mydate m3=new Mydate();
        m3.setDay(12);
        m3.setMonth(4);
        m3.setYear(1978);
        if(m2==m3)System.out.println("m2=m3");
        else System.out.println("m2!=m3");
        if(m2.equals(m3))System.out.println("m2=m3");
        else System.out.println("m2=m3");
    }
}
