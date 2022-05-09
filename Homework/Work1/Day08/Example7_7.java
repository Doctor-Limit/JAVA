package Work1.Day08;

/**
 * ********概述：
 */
public class Example7_7 {
    public static void main(String[] args) {
        int[] score = {-120, 98, 89, 120, 99};
        int sum = 0;
        for (int number :score) {
            // 若number值为true继续执行，否则立即结束执行
            assert number >= 0:"负数不能是成绩";//断言语句
            sum += number;
        }
        System.out.println("总成绩:" + sum);
    }
}
