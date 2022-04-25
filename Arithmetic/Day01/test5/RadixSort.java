package Day01.test5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ********概述：基数排序(桶排序)
 * 注意事项：本质就是空间换时间，故数据较多的情况下可能会发生异常
 *
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000); // 生成一个[0,800000)的数字
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("排序前的时间是:"+format);

        radixSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
        String format2 = simpleDateFormat1.format(date2);
        System.out.println("排序后的时间是:"+format2);
    }

    // 基数排序方法
    public static void radixSort(int[] arr) {

        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中数据，定义一个一维数组来记录每个桶中的数据个数
        int[] bucketElementCounts = new int[10];// bucketElementsCounts[0]表示的就是第一个桶中的元素个数
        // 得到数组中最大的位的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();// 即为最大元素的位数

        for (int i = 0, n = 1; i < maxLength; i++, n*= 10) {
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素的对应位数 个位--》十位--》百位
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] =arr[j];// 对应的数据要加一
            }
            // 根据这个顺序，二维数组的下标取出元素，放入原来数组
            int index = 0;
            // 遍历每一个桶，并将桶中数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 仅桶中有数据时，才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环边丽丽第k个桶，即第k个一维数组，放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                // 第一轮处理后，需要将各个桶中数据置零
                bucketElementCounts[k] = 0;
            }

        }

        // 第1轮 针对，每个元素的个位进行排序处理

        // 定义一个二维数组，表示十个桶,每个桶就是一个一维数组
        // 二维数组包含十个一维数组，为防止放入数据是数据溢出，每个桶大小都要为arr.length
//        int[][] bucket = new int[10][arr.length];
//
//        // 为了记录每个桶中数据，定义一个一维数组来记录每个桶中的数据个数
//        int[] bucketElementCounts = new int[10];// bucketElementsCounts[0]表示的就是第一个桶中的元素个数
//
//        for (int j = 0; j < arr.length; j++) {
//            // 取出每个元素的个位
//            int digitOfElement = arr[j] % 10;
//            // 放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]++] =arr[j];// 对应的数据要加一
//        }
//        // 根据这个顺序，二维数组的下标取出元素，放入原来数组
//        int index = 0;
//        // 遍历每一个桶，并将桶中数据放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            // 仅桶中有数据时，才放入到原数组
//            if (bucketElementCounts[k] != 0) {
//                // 循环边丽丽第k个桶，即第k个一维数组，放入
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    // 取出元素放入到arr
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            // 第一轮处理后，需要将各个桶中数据置零
//            bucketElementCounts[k] = 0;
//        }
//
//
//        for (int j = 0; j < arr.length; j++) {
//            // 取出每个元素的十位
//            int digitOfElement = arr[j] /10 % 10;
//            // 放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]++] =arr[j];// 对应的数据要加一
//        }
//        // 根据这个顺序，二维数组的下标取出元素，放入原来数组
//         index = 0;
//        // 遍历每一个桶，并将桶中数据放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            // 仅桶中有数据时，才放入到原数组
//            if (bucketElementCounts[k] != 0) {
//                // 循环边丽丽第k个桶，即第k个一维数组，放入
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    // 取出元素放入到arr
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//
//
//        for (int j = 0; j < arr.length; j++) {
//            // 取出每个元素的百位
//            int digitOfElement = arr[j] /100 ;
//            // 放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]++] =arr[j];// 对应的数据要加一
//        }
//        // 根据这个顺序，二维数组的下标取出元素，放入原来数组
//        index = 0;
//        // 遍历每一个桶，并将桶中数据放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            // 仅桶中有数据时，才放入到原数组
//            if (bucketElementCounts[k] != 0) {
//                // 循环边丽丽第k个桶，即第k个一维数组，放入
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    // 取出元素放入到arr
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//

    }
}
