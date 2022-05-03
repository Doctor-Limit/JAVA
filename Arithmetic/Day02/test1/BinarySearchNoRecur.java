package Day02.test1;

/**
 * ********概述：二分查找的非递归实现
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        System.out.println(binarySearch(arr, 100));

    }
    // 非递归实现
    /**
     *
     * @param arr      待查找对数组 ,数组是升序排序
     * @param target    需要查找的数
     * @return         返回对应下标，未找到则返回-1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return  -1;
    }
}
