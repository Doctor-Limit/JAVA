package Work.homework11.test2;

/**
 * ********概述：
 */
public class Soluation {
    public static void main(String[] args) {
        String details = "数学87分，物理76分，英语96分";
        int score = GetScore.givePriceSum(details);
        int numbers = GetScore.getNumbers(details);
        double aver = score / numbers;
        System.out.printf("总成绩:%d,平均分数:%f\n", score, aver);
    }
}
