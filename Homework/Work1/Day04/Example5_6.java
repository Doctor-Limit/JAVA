package Work1.Day04;

/**
 * ********概述：
 */
 class a {
     Object get(){
         return null;
     }
}
class b extends a{
     Integer get(){
         return Integer.valueOf(100);
     }
}
public class Example5_6 {
    public static void main(String[] args) {
        b c=new b();
        Integer t=c.get();
        System.out.println(t.intValue());
    }
}
