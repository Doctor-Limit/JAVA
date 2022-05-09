package Work.homework10;

import java.util.Scanner;

/**
 * ********概述：
 */


public class test {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double sum = 0;
        int m = 0;

            while (reader.hasNextDouble()) {
                double x = reader.nextDouble();
                assert (x >= 0 && x <= 100) :"数据非法";
                m = m + 1;
                sum = sum + x;
            }

        System.out.printf("%d个数的和为%f\n",m, sum);
        System.out.printf("%d个数的平均值为%f\n",m , sum/m);
    }
}
