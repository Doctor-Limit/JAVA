package Day06;

public class Person extends Student {
private  int yearsold;
public void printAge(){
    System.out.println("I am "+yearsold+" years old");
}
public int getYearsold(){
    return yearsold;
}
public void setYearsold(int yearsold){
    this.yearsold=yearsold;
    }
public Person(){
}
public Person(int yearsold){
    this.yearsold=yearsold;
}

}
