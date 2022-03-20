package Day06;

public class ExtendsTest extends Person {
    public static void main(String args[]){
      Person person=new Person(14);
      person.printAge();
      person.setSalary(0);
      person.setSex(1);
      person.manOrwoman(1);
      person.employeed(0);
    }

}
