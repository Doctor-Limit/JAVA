package Day01.test5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ********概述：
 */
public class MergeSort {
    public static void main(String[] args) {

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000); // 生成一个[0,800000)的数字
        }
        int[] temp = new int[arr.length];
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是:"+format);

        mergeSort(arr,0,arr.length-1,temp);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format2 = simpleDateFormat1.format(date2);
        System.out.println("排序后的时间是:"+format2);

    }

    //分+合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) /2;
            // 左递归
            mergeSort(arr,left,mid,temp);
            // 右递归
            mergeSort(arr,mid + 1,right,temp);
            // 进行合并
            merge(arr,left,mid,right,temp);
        }

    }

    //合并方法
    /**
     *
     * @param arr  排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right  右边索引
     * @param temp   中转数组
     */
    public static void merge(int[] arr, int left,int mid, int right, int[] temp) {
        int i = left;// 左边有序的初始索引
        int j = mid + 1;// 右边有序数列的初始索引
        int t = 0;// 指向temp数组的当前索引

        // 先把左右两边有序序列按规则填充到temp数组,直到左右两边又一遍处理完毕
        while (i <=mid && j <= right) {
            // 将左右有序序列的当前指针值比较，将数据更小的填充到temp中
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++]; // 反之，将右边的数据填充
            }
        }
        // 把有剩余数据的一方一次全部填充到temp
        while (i <= mid) { // 左边有序序列还有剩余元素，将剩余元素全部填充
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        // 将temp数组的元素拷贝到arr
        // 并不是每次都拷贝所有数据
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}
