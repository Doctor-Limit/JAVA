package Day01.test5;

import java.util.Arrays;

/**
 * ********概述：
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectionSort(arr);

    }

    // 选择排序  时间复杂度依旧为O(n^2)
    public static void selectionSort(int[] arr) {
        // 使用逐步推导的方式来讲解选择排序

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明指定的最小值并不是最小
                    min = arr[j];// 重置min
                    minIndex = j;// 重置minIndex
                }
            }
            // 将最小值交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+(i+1)+"轮后结果");
            System.out.println(Arrays.toString(arr));
        }

    }

}
