package Day01.test9;

import java.util.Arrays;

/**
 * ********概述：堆排序
 *
 */
public class HeapSort {
    public static void main(String[] args) {
        // 对该数组进行升序排序
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    // 编写一个堆排序的方法
    public static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序");

         // 通过多次分布来实现逐步调整
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次" + Arrays.toString(arr));

        // 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 将堆顶元素与末尾元素交换，将最大元素沉到数组末端
        // 重新调整结构，使其满足堆定义，然后继续交换堆顶元素和当前末尾元素，反复执行直至序列有序
        for (int j = arr.length - 1; j > 0; j--) {
            // 元素交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0 ,j);
        }

        System.out.println(Arrays.toString(arr));
    }

    // 将一个数组(二叉树),调整为大顶堆
    /**
     * 完成将以 i 对应的非叶子节点的数调整成大顶堆
     * @param arr  需要排序的数组
     * @param i    表示非叶子结点在数组中的索引
     * @param length  表示对多少个元素继续调整，length逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];// 先取出当前元素的值

        //k = k * 2 + 1是i结点的左子结点
        for (int k = i * 2 + 1;k < length;k = k * 2 + 1) {
            if (k+1 < length && arr[k] < arr[k+1]) {// 左子结点值小于右子结点
                k++;// 让k指向右子结点
                // 让k指向子结点中较大的那个结点
            }
            // 若子结点值比父结点大，将子结点的值赋给父结点，并将指向指向父结点的指针指向要该子结点
            if (arr[k] > temp) { // 子结点大于父结点
                arr[i] = arr[k];// 把较大的值赋给当前结点
                i = k;// i指向k，继续循环比较
            }else {
                break;
            }
        }
        // for循环结束后，此时已将以i为父结点的树的最大值，放到了当前子树顶部(当前子树的最大值)
        // 将原来的父结点指针保存的值赋给该子结点
        arr[i] = temp;// 将temp值方到调整后的位置
    }
}

