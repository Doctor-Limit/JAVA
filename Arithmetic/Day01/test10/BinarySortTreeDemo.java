package Day01.test10;

import java.util.Map;

/**
 * ********概述：二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
        System.out.println();
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(10);
        binarySortTree.delNode(1);

        System.out.println("删除后");
        System.out.println("根节点为"+binarySortTree.getRoot());
        System.out.println();
        binarySortTree.infixOrder();

    }
}

// 创建二叉排序树
class BinarySortTree {
    private Node root;

    // 查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        }else {
            return root.search(value);
        }
    }

    public Node getRoot() {
        return root;
    }

    // 查找父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    // 返回并删除以node为根结点的二叉排序左子树的最小结点的值
    /**
     *
     * @param node  传入的结点(当前二叉排序树的根结点)
     * @return      返回的以node为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {// 传入要删除的结点的右子结点，在右子结点的左子树中找最小
        Node target = node;
        // 在当前子树中向左找直到找到最小值
        while (target.left != null) {
            target = target.left;
        }
        // 此时target查找到了最小结点
        delNode(target.value);
        return target.value;
    }
    // 返回并删除以node为根结点的二叉排序右子树的最大结点的值
    public int delLeftTreeMax(Node node) {// 传入要删除的结点的左子结点，在左子结点的右子树中找最大
        while (node.right != null) {
            node = node.right;
        }
        delNode(node.value);
        return node.value;
    }

    // 删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        }else {
            Node targetNode = search(value);
            if (targetNode == null) { // 未找到要查找的结点
                return;
            }
            // 若当前二叉排序树只有一个结点
            if (root.right == null && root.left == null) {
                root = null;
                return;
            }
            // 去查找targetNode的父结点
            Node parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {  // 若删除的结点为叶子结点
                // 判断targetNode是父结点的左子结点还是右子结点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.right != null && targetNode.left != null) {// 删除的结点有两颗子树
                   int minVal = delRightTreeMin(targetNode.right);// 以当期结点的右子结点为根结点开始查找
                   targetNode.value = minVal;

                   // 或在左子结点的右子树中寻找最大值
//                   int maxVal = delLeftTreeMax(targetNode.left);
//                   targetNode.value = maxVal;

            }else {// 只有一颗子树的结点
                if (targetNode.left != null) { // 若要删除的结点有左子结点
                   if (parent != null) {
                       if (parent.left.value == value) {// 要删除的结点为父结点的左子结点
                           parent.left = targetNode.left;
                       } else {// 要删除的结点为父结点的右子结点
                           parent.right = targetNode.left;
                       }
                   } else {
                       root = targetNode.left;
                   }
                } else {// 若要删除的结点有右子结点
                    if (parent != null) {
                        if (parent.left.value == value) {// 要删除的结点为父结点的左子结点
                            parent.left = targetNode.right;
                        } else {// 要删除的结点为父结点的右子结点
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

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

    // 返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    // 返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回以该结点为根结点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;// 包括根结点算一层
    }

    // 查找要删除的结点
    /**
     *
     * @param value 希望删除的结点的值
     * @return       找到则返回当前结点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            // 若左子结点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    // 查找要删除的结点的父结点
    /**
     *
     * @param value  value为要查找的结点的值
     * @return       返回的是要删除的结点的父结点，没有则返回null
     */
    public Node searchParent(int value) {
        // 若当前结点就是要删除的结点的父结点
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }else {
            // 如果当前查找的值小于当前结点的值，且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);// 向左子树递归查找
            }else if(value >= this.value && this.right != null) {
                return this.right.searchParent(value); // 向右子树递归查找
            }else {
                return null;// 未找到要删除结点的父结点，例如根结点
            }
        }
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
