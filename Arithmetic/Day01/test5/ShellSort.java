package Day01.test5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ********概述： 希尔排序及其优化
 *
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000); // 生成一个[0,800000)的数字
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是:"+format);

        shellSort2(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format2 = simpleDateFormat1.format(date2);
        System.out.println("排序后的时间是:"+format2);

    }

    // 排序时使用交换法
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        // 第一轮排序
        // 将十个数据分成五组 ,五组--》5/2=2组， 2组--》2/2=1组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 初始遍历个组中所有元素，每组两个元素,步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序第"+(++count)+"轮后结果为"+Arrays.toString(arr));
        }

    }

    // 排序时使用移动法
    public static void shellSort2(int[] arr) {

        // 增量gap，逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // 退出循环后，给temp找到了插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

}
