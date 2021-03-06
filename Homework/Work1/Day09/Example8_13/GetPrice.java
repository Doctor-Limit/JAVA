package Work1.Day09.Example8_13;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ********概述：
 */
public class GetPrice {
    public static double givePriceSum(String cost) {
        Scanner scanner = new Scanner(cost);
        scanner.useDelimiter("[^0123456789.]+");
        double sum = 0;
        while (scanner.hasNext()) {
            try {
                double price = scanner.nextDouble();
                sum += price;
            }catch (InputMismatchException exp) {
                String t = scanner.next();
            }
        }
        return sum;
    }
}
