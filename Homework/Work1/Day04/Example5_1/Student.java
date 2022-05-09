package Work1.Day04.Example5_1;

/**
 * ********概述：
 */
public class Student extends People{
    int number;
    void tellNumber(){
        System.out.println("学号:"+number);
    }
    int add(int x,int y){
        return x+y;
    }
}
