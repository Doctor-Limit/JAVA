package Work1.Day01;

import java.util.*;

public class Example4_11 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int []a={12,34,9,23,45,6,90,123,19,34};
        System.out.println(Arrays.toString(a));
        System.out.println("��������,�����жϸ������Ƿ��������У�");
        int number=scanner.nextInt();
        int index=Arrays.binarySearch(a,number);
        if(index>=0)System.out.println(number+"������������Ϊ"+index+"��Ԫ��ֵ��ͬ");
        else System.out.println(number+"�����������κ�Ԫ��ֵ��ͬ");
    }
}
