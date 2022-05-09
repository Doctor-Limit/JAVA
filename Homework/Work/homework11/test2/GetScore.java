package Work.homework11.test2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * ********概述：
 */
public class GetScore {
    public static int givePriceSum(String details) {
        Scanner scanner = new Scanner(details);
        scanner.useDelimiter("[^0123456789.]+");
        int sum = 0;
        while (scanner.hasNext()) {
            try {
                double score = scanner.nextDouble();
                sum += score;
            }catch (InputMismatchException e) {
                String t = scanner.next();
            }
        }
        return sum;
    }

    public static int getNumbers(String details) {
            String regex = "[^0123456789.]+";
            details = details.replaceAll(regex,"#");
            StringTokenizer fenxi = new StringTokenizer(details, "#");
            int amount = fenxi.countTokens();
            return amount;
    }

}
