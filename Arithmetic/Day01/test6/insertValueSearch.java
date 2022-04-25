package Day01.test6;

/**
 * ********概述：插值查找
 */
public class insertValueSearch {
    public static void main(String[] args) {
        int[] arr  = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println(index);

    }

    // 编写插值查找算法
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        // 防止得到的mid值越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出mid  本身的值也参与对mid的计算  自适应：在一些连续的数字上十分方便
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 向右递归查找
            return insertValueSearch(arr, mid + 1, right, findVal);
        }else if (findVal < midVal) {
            return insertValueSearch(arr, left ,mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
