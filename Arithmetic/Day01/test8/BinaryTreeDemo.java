package Day01.test8;

/**
 * ********概述：
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 先创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        // 先手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root); // 提供二叉树的根节点

//        // 测试前序遍历
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        System.out.println();
//
//        // 测试中序遍历
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        System.out.println();
//
//        // 测试后序遍历
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

        HeroNode resNode1 = binaryTree.preOrderSearch(5);
        if (resNode1 != null) {
            System.out.printf("找到目标，目标信息为no=%d name=%s",resNode1.getNo(),resNode1.getName());
        }else {
            System.out.println("未找到目标");
        }


    }
}

// 定义binaryTree二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    // 前序遍历
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    // 中序遍历
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    // 后序遍历
    public HeroNode postSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    // 删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树，不能删除");
        }
    }

}

// 先创建HeroNode节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HeroNode getLeft() {
        return left;
    }
    public HeroNode getRight() {
        return right;
    }
    public void setLeft(HeroNode left) {
        this.left = left;
    }
    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '}';
    }

    // 递归删除节点 若为叶子结点，则删除该节点，非叶子节点则删除该子树
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        // 左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        // 说明左边已经遍历完开始遍历右子树
        if (this.right != null) {
            this.right.delNode(no);
        }

    }

    // 节点的前序遍历  根左右
    public void preOrder() {
        System.out.println(this); // 输出父节点
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历     左根右
    public void infixOrder() {
        // 左子树递归
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历     左右根
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序遍历查找
    /**
     * 根左右
     * @param no 要查找的编号
     * @return   找到就返回该node，未找到就返回null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进行前序遍历");
        // 判断当前节点是不是
        if (this.no == no) {
            return this;
        }
        // 判断左节点是否为空，不为空则递归前序查找
        // 左递归前序查找，找到节点则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        // 左递归未找到目标节点，判断当前右节点是否为空，继续向右前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    // 中序遍历
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    // 后序遍历
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (null != resNode) {
            return resNode;
        }

        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}
