package Day01.test10;

/**
 * ********概述：平衡二叉树
 *  在二叉排序树的基础上确保左右子树的高度差小于二
 *  在大于二的情况下，若右高度大于左高度，则需左旋，反之，右旋
 *
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};

        // 创建一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
           avlTree.add(new Node(arr[i]));
        }

        // 遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("进行平衡处理");
        System.out.println(avlTree.getRoot().height());// 树的高度
        System.out.println("左子树高度:" + avlTree.getRoot().leftHeight());
        System.out.println("右子树高度:" + avlTree.getRoot().rightHeight());


    }
}

// 创建AVLTree
class AVLTree {
    private Node root;

    // 查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
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
        } else {
            return root.searchParent(value);
        }
    }

    // 返回并删除以node为根结点的二叉排序左子树的最小结点的值

    /**
     * @param node 传入的结点(当前二叉排序树的根结点)
     * @return 返回的以node为根结点的二叉排序树的最小结点的值
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
        } else {
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
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.right != null && targetNode.left != null) {// 删除的结点有两颗子树
                int minVal = delRightTreeMin(targetNode.right);// 以当期结点的右子结点为根结点开始查找
                targetNode.value = minVal;

                // 或在左子结点的右子树中寻找最大值
//                   int maxVal = delLeftTreeMax(targetNode.left);
//                   targetNode.value = maxVal;

            } else {// 只有一颗子树的结点
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
                    } else {
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
        } else {
            root.add(node);
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }
}
