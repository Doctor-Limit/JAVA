package Day01.test6;

import java.util.ArrayList;
import java.util.List;

/**
 * ********概述：线性查找
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, -3, 9, -4, 4, 5, -3};
        System.out.println(seqSearch(arr, -3));
    }
    // 找到第一个值就会返回
    public static List<Integer> seqSearch(int[] arr, int value) {
        List<Integer> list = new ArrayList<>();
        // 线性查找逐一比对，发现相同即返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                list.add(i);
            }
        }
        return list;
    }

}
