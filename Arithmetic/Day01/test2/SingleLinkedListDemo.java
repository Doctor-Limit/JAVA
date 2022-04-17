package Day01.test2;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static Day01.test2.SingleLinkedList.*;

/**
 * ********概述：
 */
public class SingleLinkedListDemo {

    @Test
    public void test1(){
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        list1.addByOrder(node2);
        list1.addByOrder(node1);
        list2.addByOrder(node4);
        list2.addByOrder(node3);

        SingleLinkedList list = mergeLinkedList(list1.getHead(), list2.getHead());
        list.list();

    }

    public static void main(String[] args) {
        //测试，创建节点
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");

        //创建初始链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入元素(链表顺序根据添加顺序)
//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node4);

        //根据要求添加数据，链表顺序根据要求来定
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node2);


        singleLinkedList.list();
        System.out.println();

       // reverseList(singleLinkedList.getHead());

        // 未改变链表本身结构
        reversePrint(singleLinkedList.getHead());

//
//        //测试修改节点的代码
//        HeroNode newNode = new HeroNode(2, "个卢", "000");
//        singleLinkedList.update(newNode);
//
//        singleLinkedList.del(2);
//
//        //显示
//        System.out.println("修改后的情况");
//        singleLinkedList.list();
//        System.out.printf("有效的节点个数= "+getLength(singleLinkedList.getHead()));
//        System.out.println();
//
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),2);
//        System.out.println("res=" + res);

    }
}

class SingleLinkedList{

    //先初始化一个头结点,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    // 返回头节点
    public HeroNode getHead() {
        return head;
    }
    // 获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
    /*
    @param head 链表的头节点
    @return 返回的就是有效节点的个数

     */
    public static int getLength(HeroNode head){
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        // 定义一个辅助变量,未统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    // 合并两个有序的单链表，合并之后的链表依然有序
    public static SingleLinkedList mergeLinkedList(HeroNode head1, HeroNode head2) {
        SingleLinkedList linkedList = new SingleLinkedList();
        HeroNode cur = linkedList.head;
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        while (true) {
            if (cur1.next == null && cur2.next != null) {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            if(cur2.next == null && cur1.next != null) {
                cur.next = cur2;
                cur = cur.next;
                cur.next = cur1;
                cur1 = cur1.next;
            }
            if (cur1.next == null && cur2.next == null) {
                break;
            }
            if (cur1.no >= cur2.no) {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            else if (cur1.no < cur2.no) {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }

        return linkedList;
    }

    // 利用栈这个数据结构，将各个节点压入到栈中，最后利用栈的先进后出的特点，实现了逆序打印
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;// 空链表，无法打印
        }
        // 创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表所有节点压入栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next;// 后移，压入下一个节点
        }
        // 将栈中的节点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());// stack特点：先进后出
        }
    }

    /*
    将单链表反转
     */
    public static void reverseList(HeroNode head){
        // 若当前链表为空或只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点cur的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        // 遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reserveHead的最前端

        while (cur != null) {
            next = cur.next;// 暂时保存当前节点的下一个节点，后面需要使用
            cur.next = reverseHead.next;
            reverseHead.next = cur;// 将cur连接到新的链表
            cur = next;// cur右移
        }
        //将head.next指向reserve.next,实现链表的反转
        head.next = reverseHead.next;
    }

    /*
    查找单链表的倒数第k个节点
    1、编写一个方法，接收head节点，同时接受一个index
    2、index表示倒数第index个节点
    3、先把链表从头到尾遍历，得到链表的总长度
    4、得到总长度后，遍历到（总长度-index）那个，就可得到
    5、找到了返回该节点，否则返回null
     */

    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        // 若为空，返回null
        if (head.next == null) {
            return null;// 未找到
        }
        // 遍历得到链表的长度(节点个数)
        int size = getLength(head);
        // 第二次遍历到 size-index 位置，就是我们倒数的第k个节点
        // 对index进行判断
        if (index <= 0 || index > size) {
            return null;
        }
        // 定义辅助变量
        HeroNode cur = head.next;
        for (int i = 0;i < size-index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    //添加节点到单向链表
    //不考虑编号顺序时，找到当前链表的最后节点，将最后节点的next 指向 新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能移动，所以要定义一个辅助变量遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到最后，则将temp后移
            temp = temp.next;
        }
        //退出while循环时，temp就被指向了链表的最后
        temp.next = heroNode;
    }

    //第二种添加英雄方式：根据排名插入到指定位置(若已存在，则添加失败并给出提示)
    public void addByOrder(HeroNode heroNode){
        //头结点不能动，通过一个辅助指针(变量)来帮助找到要添加的位置
        //因为单链表，我们找到的temp是位于添加位置的前一个节点，否则无法插入
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){//位置找到，在temp后面插入数据
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag值
        if(flag){//说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在，不能添加\n",heroNode.no);
        }else {
            //插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据编号修改信息，其no编号不可改
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空~~");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true){
            if(temp == null){
                break;//已经遍历完链表
            }
            if(temp.no == newHeroNode.no){
                flag = true;//找到该元素
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到需要修改的节点
        if(flag){
            temp.nickname = newHeroNode.nickname;
            temp.name = newHeroNode.name;
        }else{//未找到
            System.out.printf("没有找到编号 %d 的节点，不能修改\n",newHeroNode.no);
        }
    }

    // 删除节点
    /*
    1、head 不能动，因此需要一个temp辅助节点找到删除节点的前一个节点
    2、比较时，是 temp.next.no 和 需要删除的节点的no比较
     */
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {// 标志是否已找到待删除节点
                break;
            }
            if (temp.next.no == no) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;// temp后移
        }
        // 判断flag
        if (flag) {
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的 %d 节点不存在\n",no);
        }
    }

    //显示链表（遍历）
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if(temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //输出后将节点后移
            temp=temp.next;
        }
    }

}

//定义HeroNode，每个 HeroNode 对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int hNo,String hName,String hNickname){
        this.no=hNo;
        this.name=hName;
        this.nickname=hNickname;
    }

    //显示方法
    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}
