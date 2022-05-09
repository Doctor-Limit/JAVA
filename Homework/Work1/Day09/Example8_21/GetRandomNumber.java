package Work1.Day09.Example8_21;

import java.util.Random;

/**
 * ********概述：
 */
public class GetRandomNumber {
    public static int[] getRandomNumber(int max, int amount) {
        int[] randomNumber = new int[amount];
        int index = 0;
        randomNumber[0] = -1;
        Random random = new Random();
        while (index < amount) {
            int number = random.nextInt(max) + 1;
            boolean isInArrays = false;
            for (int m : randomNumber) {
                if (m == number) {
                    isInArrays = true;
                }
            }
            if (isInArrays == false) {
                randomNumber[index] = number;
                index++;
            }
        }
        return randomNumber;
    }
}