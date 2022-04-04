package Work1.Day02;
import java.util.*;

public class Example4_16 {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println("本地机器的时间：");
        System.out.println(date.toString());
        int []a={12,34,-34,2,100};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
