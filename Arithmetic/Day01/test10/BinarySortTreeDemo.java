package Day01.test10;


/**
 * ********概述：二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
    }
}

// 创建二叉排序树
class BinarySortTree {
    private Node root;
    // 添加结点
    public void add(Node node) {
        if (root == null) {
            root = node; // 若根节点为空，则作为根节点
        }
        else {
            root.add(node);
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }else {
            System.out.println("二叉排序树为空");
        }
    }
}

// 创建node结点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // 添加结点的方法
    // 递归形式添加节点
    public void add(Node node) {
        if (node == null) {
            return;
        }

        // 判断当前传入的结点的值，和当前子树的根结点的关系
        if (node.value < this.value) {
            if (this.left == null) {// 当前结点的左子结点为null
                this.left = node;
            }else {
                this.left.add(node);// 递归向左子树添加
            }
        }else {// 添加的结点的值大于当前结点的值
            if (this.right == null) {
                this.right = node;
            }else {
                this.right.add(node);// 递归向右子树添加
            }
        }

    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    // 提供中序遍历方法
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
