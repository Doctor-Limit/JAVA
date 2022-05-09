package Work1.Day09.Example8_13;

/**
 * ********概述：
 */
public class Example8_13 {
    public static void main(String[] args) {
        String cost = "市话76.8元，长途167.38元，短信12.68元";
        double priceSum = GetPrice.givePriceSum(cost);
        System.out.printf("%s\n总价:%.2f元\n",cost,priceSum);
        cost = "牛奶8.5元，香蕉3.6元，酱油2.8元";
        priceSum = GetPrice.givePriceSum(cost);
        System.out.printf("%s\n总价:%.2f元\n",cost,priceSum);
    }
}
