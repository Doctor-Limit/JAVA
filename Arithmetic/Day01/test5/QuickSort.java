package Day01.test5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ********概述： 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000); // 生成一个[0,800000)的数字
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是:"+format);

        quickSort(arr,0,arr.length-1);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format2 = simpleDateFormat1.format(date2);
        System.out.println("排序后的时间是:"+format2);

    }

    public static void quickSort(int[] array, int left, int right) {
        if (left>=right) return ;
        int start=left;
        int end=right;
        int flag=(left+right) / 2;
        int tmp = 0;
        while(left<right) {// 进入时left < right即可
            while ((left<right)&&(array[right]>=array[flag])) { // 但循环时要保证二者不能相等
                right--;
            }
            if (array[right]<array[flag]) {
                tmp=array[right];
                array[right]=array[flag];
                array[flag]=tmp;
                flag=right;
            }
            while ((left<right)&&(array[left]<=array[flag])) {
                left++;
            }
            if (array[left]>array[flag]) {
                tmp=array[left];
                array[left]=array[flag];
                array[flag]=tmp;
                flag=left;
            }
        }
        quickSort(array, start, left-1);
        quickSort(array, left + 1, end);
    }

}
