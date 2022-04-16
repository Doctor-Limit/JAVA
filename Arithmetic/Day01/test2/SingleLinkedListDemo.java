package Day01.test2;

/**
 * ********概述：
 */
public class SingleLinkedListDemo {

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

        //测试修改节点的代码
        HeroNode newNode = new HeroNode(2, "个卢", "000");
        singleLinkedList.update(newNode);

        singleLinkedList.del(5);

        //显示
        System.out.println("修改后的情况");
        singleLinkedList.list();

    }
}

class SingleLinkedList{

    //先初始化一个头结点,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

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
