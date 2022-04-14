package Day05.test1;

import Day01.test8.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * ********概述：
 */
public class PersonData {
    public static List<Person> getPeople(){
        List<Person> list=new ArrayList<>();
        list.add(new Person("Tom",12));
        list.add(new Person("Jack",21));
        list.add(new Person("Marry",23));
        list.add(new Person("Petter",14));
        list.add(new Person("Alice",22));
        list.add(new Person("Mark",19));
        list.add(new Person("LiMing",17));

        return list;
    }
}
