package Day01.test2;

/**
 * ********概述：
 */
public class Josepfu {
    public static void main(String[] args) {
        System.out.println("环形链表测试~~~");
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addBoy(25);
        linkedList.showBoy();
        System.out.println();

        System.out.println("小孩出圈~~~\n");
        linkedList.countBoy(1,2,25); // 开始的编号  周期  总共多少节点
    }
}

// 创建一个环形的单向链表
class CircleSingleLinkedList{
    // 创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);
    //添加节点构建成环形链表
    public void addBoy(int nums){
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;// 辅助指针，帮忙构建环形链表
        // 利用for循环构建环形链表
        for (int i = 1;i < nums+1; i++) {
            //根据编号创建节点
            Boy boy = new Boy(i);
            //若是第一个节点
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy(){
        //判断是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，使用辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n",curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    // 根据用户的输入，计算出节点出圈的顺序

    /**
     *
     * @param startNo:表示从第几个小孩开始数数
     * @param countNum：表示数几下
     * @param nums：表示最初有多少个小孩节点
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 创建辅助指针，帮助完成节点出圈
        Boy helper = first;
        // 创建helper，事先指向环形链表的最末尾的节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前，先让first和helper移动k-1次
        for (int j = 0;j < startNo-1;j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        // 循环直至圈中只有一个节点
        while (true) {
            if (helper == first) {
                break;
            }
            for (int j = 0;j < countNum-1;j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 此时first指向的节点便是要出圈的节点
            System.out.printf("小孩节点 %d \n",first.getNo());
            // 将first节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后的小孩编号%d \n",first.getNo());
    }
}

// 创建一个类，类的一个对象表示一个节点
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }
    public Boy getNext() {
        return next;
    }
    public void setNext(Boy next) {
        this.next = next;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    @Override
    public String toString() {
        return "Boy{" + "no=" + no + '}';
    }
}