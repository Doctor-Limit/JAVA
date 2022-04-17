package Day01.test2;

import org.junit.jupiter.api.Test;

/**
 * ********概述：
 */
public class DoubleLinkedListDemo {

    @Test
    public void test1(){
        HeroNode2 node1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 node3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 node4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList list = new DoubleLinkedList();
        list.addByOrder(node2);
        list.addByOrder(node4);
        list.addByOrder(node3);
        list.addByOrder(node1);
        list.list();

    }
    public static void main(String[] args) {
        System.out.println("双向链表测试~~~\n");

        HeroNode2 node1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 node3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 node4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList list = new DoubleLinkedList();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        list.list();
        System.out.println();

        HeroNode2 heroNode2 = new HeroNode2(4, "1", "2");
        list.update(heroNode2);
        list.list();
        System.out.println();

        list.del(3);
        list.list();

    }
}

class DoubleLinkedList{

    //初始化头节点，头节点不动
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }
    public void add(HeroNode2 heroNode){
        //因为head节点不能移动，所以要定义一个辅助变量遍历temp
        HeroNode2 temp = head;
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
        heroNode.pre = temp;
        //形成一个双向链表
    }

    //根据编号大小添加 指针转化需要四个语句，因为插入需要用到四个指针
    public void addByOrder(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode2.no) {
                break;
            }else if (temp.next.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在，不能添加\n",heroNode2.no);
        }else {
            if (temp.next == null) {
                temp.next = heroNode2;
                heroNode2.pre = temp;
            }else {
                   heroNode2.next = temp.next;
                   temp.next.pre = heroNode2;
                   temp.next = heroNode2;
                   heroNode2.pre = temp;
            }
        }
    }

    //修改节点的信息，改变节点类型即可
    public void update(HeroNode2 newHeroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空~~");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
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

    //双向链表删除节点
    //不需要找到前一个节点，可以直接删除需要删除的节点
    public void del(int no){
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null){
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //如果是最后一个节点，不需要执行下面，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;//要删除的节点为最后一个时代码可能出现问题
            }
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
        HeroNode2 temp = head.next;
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

// 定义双向链表
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;// 指向下一个节点，默认为null
    public HeroNode2 pre; // 指向前一个节点，默认为null

    public HeroNode2(int no, String name, String nickname){
        this.name = name;
        this.nickname = nickname;
        this.no = no;
    }
    @Override
    public String toString() {
        return "HeroNode2{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + '\'' + '}';
    }
}
