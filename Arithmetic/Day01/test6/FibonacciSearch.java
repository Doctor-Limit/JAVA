package Day01.test6;

import java.util.Arrays;
import java.util.Map;

/**
 * ********概述：斐波那契数列查找
 * mid = low + F(k-1) - 1
 *
 * F(k) = F(k-1)+F(k-2) ==> F(K)-1 = (F(K-1)-1)+(F(k-2)-1)+1
 * 所以元素个数一定要为(F(k)-1)的倍数
 *
 */
public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr,89));
    }

    // 因为 mid = low + F(k-1) - 1，所以当使用斐波那契数列，我们需要先获取到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i -1] + f[i -2];
        }
        return f;
    }

    // 编写斐波那契查找算法，使用非递归编写
    /**
     *
     * @param a 数组
     * @param key  需要查找的关键值
     * @return  对应下标，若没有则返回-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;// 表示菲波那切数列分割数值对应的下标
        int mid = 0;
        int f[] = fib();// 获取到菲波那切数列
        // 获取分割数列的下标
        while (high > f[k] - 1) {
            k++;
        }
        // 因为f[k]值可能大于 a 的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        int[] temp = Arrays.copyOf(a, f[k]); // 不足的部分会使用0填充,f[k]是填充长度是mid值始终保持0.618比例
        // 但需求是用a数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = temp[high];
        }
        // 使用while来循环处理，找到最后的key
        while (low <= high) {
            mid = low + f[k-1] - 1;
            if (key < temp[mid]) { // 向数组左方查找
                high = mid -1;
                /*
                f[k] = f[k-1]+f[k-2],因为前面有k-1个元素，可以继续拆分f[k-1] = f[k-2]+f[k-3]
                即在f[k-1]的前面继续查找k--，下次mid = f[k-1-1]-1
                 */
                k--;
            }else if (key > temp[mid]) {
                low = mid + 1;
                /*
                f[k] = f[k-1]+f[k-2],因为前面有k-2个元素，可以继续拆分f[k-2] = f[k-3]+f[k-4]
                即在f[k-2]的前面继续查找k--，下次mid = f[k-1-2]-1
                 */
                k -= 2;
            }else {
                // 需要确定返回的下标,当使用补长后的数组，此时返回的mid值可能超过原数组索引，故返回最后一个索引
                return mid <= high ? mid : high;// 返回二者中小的那一个
            }
        }
        return  -1;// 未找到-1
    }

}
