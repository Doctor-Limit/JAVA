package Day01.test5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ********概述： 插入排序
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000); // 生成一个[0,800000)的数字
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是:"+format);

        insertSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format2 = simpleDateFormat1.format(date2);
        System.out.println("排序后的时间是:"+format2);

    }

    // 插入排序
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;// 即arr[1]前一个数据的坐标

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            // 判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

        }
//        // 第一轮
//        // 定义待插入的数据
//        int insertVal = arr[1];
//        int insertIndex = 1 - 1;// 即arr[1]前一个数据的坐标
//
//        // 给insertVal 找到插入的位置
//        // insertIndex = 0 确保在insertVal 时插入位置不越界
//        // insertVal < arr[insertIndex]说明待插入的数还未找到位置
//        // 所以需要将arr[insertIndex] 后移
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        // 退出此循环时，说明插入的位置找到，insertIndex + 1
//        arr[insertIndex + 1] = insertVal;
//
    }

}
