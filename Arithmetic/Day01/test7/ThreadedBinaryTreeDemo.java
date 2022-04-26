package Day01.test7;
/**
 * ********概述：线索化二叉树
 * 根据遍历顺序的不同，结点可 表示的前驱和后继结点不同
 *
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode1 root = new HeroNode1(1,"tom");
        HeroNode1 node2 = new HeroNode1(3,"jack");
        HeroNode1 node3 = new HeroNode1(6,"smith");
        HeroNode1 node4 = new HeroNode1(8,"mary");
        HeroNode1 node5 = new HeroNode1(10,"king");
        HeroNode1 node6 = new HeroNode1(14,"dim");

        // 递归创建二叉树，目前先简单处理
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        System.out.println("10号的前驱结点是"+node5.getLeft());
        System.out.println("10号的后继结点是"+node5.getRight());

        // 线索化二叉树后，原先的二叉树遍历方法不再适用


    }
}
class ThreadedBinaryTree {
    private HeroNode1 root;
    // 实现线索化需要创建指向当前结点的前驱结点的指针
    // 在递归实现线索化时，pre始终指向前一个结点
    private HeroNode1 pre = null;

    public void setRoot(HeroNode1 root) {
        this.root = root;
    }

    // 重载实现线索化方法，美观
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    // 编写对二叉树进行中序线索化的方法
     public void threadedNodes(HeroNode1 node) {// Node就是当前需要线索化的结点
        // 如果Node ==  null，不能线索化
         if (node == null) {
             return;
         }
         // 线索化左子树--》
         threadedNodes(node.getLeft());
         // 线索化当前节点--》

         // 1、处理当前结点的前驱结点
         if (node.getLeft() == null) {
             // 让当前结点的左指针指向前驱结点
             node.setLeft(pre);
             // 修改当前节点的左指针的类型，指向前驱结点
             node.setLeftType(1);
         }
         // 2、处理当前结点的后继结点，实际上是在下一次当前节点作为下一次的前驱结点处理来实现处理当前结点的后继
         if (pre != null && pre.getRight() == null) {
             // 让前驱结点的右指针指向当前结点
             pre.setRight(node);
             pre.setRightType(1);
         }

         pre = node;// 每处理一个结点，让当前结点是下一个结点的前驱结点

         // 线索化右子树
         threadedNodes(node.getRight());

     }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    // 前序遍历
    public HeroNode1 preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    // 中序遍历
    public HeroNode1 infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    // 后序遍历
    public HeroNode1 postSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    // 删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除");
        }
    }
}
// 先创建HeroNode节点
class HeroNode1 {
    private int no;
    private String name;
    private HeroNode1 left;
    private HeroNode1 right;
    //若leftType == 0表明指向左子树，1表示指向前驱结点
    //同理，rightType== 0表明指向右子树，1表示指向后继节点
    private int leftType;
    private int rightType;

    public HeroNode1(int no, String name) {
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
    public HeroNode1 getLeft() {
        return left;
    }
    public HeroNode1 getRight() {
        return right;
    }
    public void setLeft(HeroNode1 left) {
        this.left = left;
    }
    public void setRight(HeroNode1 right) {
        this.right = right;
    }
    public int getLeftType() {
        return leftType;
    }
    public int getRightType() {
        return rightType;
    }
    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }
    public void setRightType(int rightType) {
        this.rightType = rightType;
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
    public HeroNode1 preOrderSearch(int no) {
        System.out.println("进行前序遍历");
        // 判断当前节点是不是
        if (this.no == no) {
            return this;
        }
        // 判断左节点是否为空，不为空则递归前序查找
        // 左递归前序查找，找到节点则返回
        HeroNode1 resNode = null;
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
    public HeroNode1 infixOrderSearch(int no) {
        HeroNode1 resNode = null;
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
    public HeroNode1 postOrderSearch(int no) {
        HeroNode1 resNode = null;
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




