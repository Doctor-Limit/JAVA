package Work1.Day01;

class Computer{
    int add(int a,int b){
        return a+b;
    }
}
public class Example4_6 {
    public static void main(String[] args) {
        Computer computer=new Computer();
        int m=100;
        int n=200;
        int result=computer.add(m,n);
        System.out.println(result);
        result=computer.add(120+m,n*10+8);
        System.out.println(result);
    }
}
