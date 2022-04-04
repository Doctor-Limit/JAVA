package Work1.Test.test1;

public class test2{
        public static void f(int ...x){//x是可变参数的代表，代表若干个int型参数
            for(int i=0;i<x.length;i++){
                System.out.print(x[i]+" ");
            }
        }
    public static void main(String[] args) {
        f(1,2);
        f(-1,-2,-3,-4);
        f(7,3,-3,2);
    }
}
