package Day01.test8;

/**
 * ********概述： 以数组方式实现二叉树的遍历
 * 顺序存储二叉树
 *
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();

    }
}

// 编写一个ArrayBinaryTree，实现顺序存储二叉树遍历
class ArrBinaryTree {
    private int[] arr;// 存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    // 编写一个方法，完成顺序二叉树的前序遍历
    public void preOrder(int index) {// 数组下标
        // 若数组为空或长度为0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        // 输出当前这个元素
        System.out.print(arr[index]+" ");
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);// 第n个元素左节点下标为2*n+1
        }
        // 向右遍历递归
        if ((index * 2 + 2) < arr.length) {// 第n个元素右节点下标为2*n+2
            preOrder(2 * index + 2);
        }
        // 同理：当前节点n的父节点下标为(n - 1) / 2
    }

    // 其他顺序遍历改变输出语句顺序即可
}
