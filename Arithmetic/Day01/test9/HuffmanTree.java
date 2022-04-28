package Day01.test9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ********概述： 霍夫曼树的代码实现
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        preOrder(root);

    }

    //编写一个前序遍历方法用于显示霍夫曼树
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("空树，无法遍历");
        }
    }

    // 创建霍夫曼树的方法
    /**
     * @param arr 要被创建成霍夫曼树的数组
     * @return    霍夫曼树创建好后的根结点
     */
    public static Node createHuffmanTree(int[] arr) {
        // 遍历数组并将元素构建为Node。将其放入ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        // 每对结点进行操作后，直至只有最后一个节点，就进行排序
        while (nodes.size() > 1) {
            // 从小到大排序
            Collections.sort(nodes);

            // 取出根结点权值最小的两颗二叉树
            //(1)取出权值最小的结点(二叉树)
            Node leftNode = nodes.get(0);

            //(2)取出权值次小的结点(二叉树)
            Node rightNode = nodes.get(1);

            //(3)以这两个为结点构建新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //(4)从ArrayList中删除已处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //(5)将新创建的结点加入到该二叉树
            nodes.add(parent);
        }
        // 返回霍夫曼树的根结点
        return nodes.get(0);
    }
}

// 创建结点类
// 让Node对象支持排序，让其实现Comparable接口
class Node implements Comparable<Node>{
    int value; // 结点权值
    Node left;
    Node right;

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.value - o.value;
    }
}
