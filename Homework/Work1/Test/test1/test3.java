package Work1.Test.test1;

class AAA{
    static {
        System.out.println("AAA中静态块");
    }
}
public class test3 {
    static {
        System.out.println("最先被执行代码块");
    }
    public static void main(String[] args) {
        AAA a=new AAA();
        System.out.println("了解静态块");
    }
}
