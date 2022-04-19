package Day01.test3;

import java.io.DataInputStream;

/**
 * ********概述：
 */
public class SingleLinkedListStackDemo {
    public static void main(String[] args) {
        Node node1 = new Node(0,1);
        Node node2 = new Node(1,2);
        Node node3 = new Node(2,3);

        SingleLinkedListStack stack = new SingleLinkedListStack();
        stack.push(node1);
        stack.push(node2);
        stack.push(node3);

        stack.list();

        try {
            System.out.printf("取出的数据是%d\n",stack.pop().getNum());
            System.out.printf("取出的数据是%d\n",stack.pop().getNum());
            System.out.printf("取出的数据是%d\n",stack.pop().getNum());
            System.out.printf("取出的数据是%d\n",stack.pop().getNum());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class SingleLinkedListStack {
   private Node head = new Node(0,0);

    public Node getHead() {
        return head;
    }

   public void push(Node node) {
        if (head.getNext() == null) {
            head.setNext(node);
        }else {
            node.setNext(head.getNext());
            head.setNext(node);
        }

   }

   public Node pop() {
        if (head.getNext() == null){
           throw new RuntimeException("栈空，无数据");
        }
        Node cur = head.getNext();
        head.setNext(cur.getNext());
        return cur;
   }

   public void list(){
        if (head.getNext() == null) {
            System.out.println("链表为空\n");
            return;
        }
        Node cur = head.getNext();
        while (true) {
            if (cur == null) {
                break;
            }
            System.out.println(cur);
           cur = cur.getNext();
        }

   }
}

class Node {
    private int no;
    private int num;
    private Node next;

    public Node(int hNo ,int num) {
        this.no = hNo;
        this.num = num;
    }
    public int getNum() {
        return num;
    }
    public Node getNext() {
        return next;
    }
    public int getNo() {
        return no;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return "Node{" + "no=" + no + ", num=" + num + '}';
    }
}
