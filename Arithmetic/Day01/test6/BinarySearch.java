package Day01.test6;

import java.util.ArrayList;
/**
 * ********概述：二分查找
 * 前提：该数组必须有序
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        ArrayList result = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(result);

    }

    // 二分查找的优化，当存在多个相同数据值时，返回全部的索引
    // 在找到索引值时不马上返回，对索引左边进行扫描，将所有满足该元素的下标加入到集合中
    // 同理对右边进行同样的操作,最后将这个集合返回
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int finalVal) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (finalVal > midVal) {
            return binarySearch2(arr,mid + 1, right, finalVal);
        }else if (finalVal < midVal) {
            return binarySearch2(arr, left, mid - 1, finalVal);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            // 向左边扫描，将满足的索引加入集合
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != finalVal) {
                    break;
                }
                list.add(temp--);
            }
            list.add(mid);

            // 右边扫描
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != finalVal) {
                    break;
                }
                list.add(temp++);
            }
            return list;
        }
    }

    // 二分查找算法
    /**
     *
     * @param arr  数组
     * @param left  左边的索引
     * @param right  右边的索引
     * @param finalVal  要查找的值
     * @return  找到则返回小标，未找到则返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int finalVal) {
        // 当 left > right 时，说明遍历整个数组后也未找到  避免死递归
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (finalVal > midVal) {
            return binarySearch(arr,mid + 1, right, finalVal);
        }else if (finalVal < midVal) {
            return binarySearch(arr, left, mid - 1, finalVal);
        }else {
            return mid;
        }
    }

}
