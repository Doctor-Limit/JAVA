package Day01.test5;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ********概述：
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectionSort(arr);

    }

    //速度测试
    @Test
    public void test1() {

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000); // 生成一个[0,800000)的数字
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是:"+format);

        selectionSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format2 = simpleDateFormat1.format(date2);
        System.out.println("排序后的时间是:"+format2);

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
        }

    }

}
