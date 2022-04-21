package Day01.test5;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ********概述：
 *  冒泡排序的实现及其优化
 */
public class BubbleSort {

    // 将此冒泡排序封装成一个算法
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;// 表示变量，表示是否进行过交换，若未交换则直接退出来进行优化
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[i] > arr[i+1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            if (!flag) { // 说明在此次排序中，一次交换都未发生
                break;
            }else {
                flag = false; // 重置flag并进行下次判断
            }
        }
    }

    //测试冒泡排序的速度O(n^2),80000个数据进行测试
    //创建80000个数据的随机数组
    @Test
    public void test2(){

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000); // 生成一个[0,800000)的数字
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是:"+format);

        bubbleSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format2 = simpleDateFormat1.format(date2);
        System.out.println("排序后的时间是:"+format2);

    }

    // 冒泡实现及其优化
    @Test
    public void test1(){
        int[] arr = {3, 9, -1, 10, -2};

        //第一次排序，将最大的数排在最后
        int temp = 0;
        boolean flag = false;// 表示变量，表示是否进行过交换
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[i] > arr[i+1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            if (!flag) { // 说明在此次排序中，一次交换都未发生
                break;
            }else {
                flag = false; // 重置flag并进行下次判断
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};

        //第一次排序，将最大的数排在最后
        int temp = 0;
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第一次排序后数组");
        System.out.println(Arrays.toString(arr));

        // 第二次排序，将第二大的数排在倒数第二位
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i+1]) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第二次排序后数组");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
