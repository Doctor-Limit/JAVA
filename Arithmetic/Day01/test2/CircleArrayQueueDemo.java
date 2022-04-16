package Day01.test2;

import java.util.Scanner;

import static Day01.test2.ArrayQueen.menu;

/**
 * ********概述：数组实现环形队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray queen = new CircleArray(4);//其队列的有效数据最多为3
        char key=' ';//供用户输入
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            menu();
            System.out.println("请输入：");
            key=scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':queen.showQuene();break;
                case 'a':
                    System.out.println("请输入要添加的一个数");
                    int value=scanner.nextInt();
                    queen.addQuene(value);
                    break;
                case 'g':
                    try {
                        int res=queen.getQueen();
                        System.out.printf("取出的数据是:%d",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
                case 'h':
                    try{
                        int res=queen.headQunen();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    System.out.println("输入有误:");
                    break;
            }
        }
        System.out.println("程序退出~~~");

    }
}
class CircleArray{
    /*
    此方法默认数组中存在一个空位，当maxSize=8时，实际上存入的最多只有7个数据，
    因此若当maxSize=1时，即使数组为空也默认为已满
    故可以得出(rear+1)%maxSize==front判断已满
     */

    private int maxSize;
    private int front;//front指向队列的第一个元素，初始值为0
    private int rear;//rear指向最后一个元素的后一个位置，希望空出一个空间(该空间永远不会存储数据)，初始值为0
    private int[] arr;

    public static void menu(){
        System.out.println("s(show):显示队列");
        System.out.println("e(exit):退出程序");
        System.out.println("a(add):添加数据到到队列");
        System.out.println("g(get):从队列中取出数据");
        System.out.println("h(head):查看队列头的数据");
    }

    public CircleArray(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    //判断是否队列满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    //判断是否队列空
    public boolean isEmpty(){
        return front==rear;
    }

    //添加数据到队列
    public void addQuene(int n){
        //判断是否已满
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
       //直接将数据加入即可，再将rear后移
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    //获取队列的数据，出队列
    public int getQueen(){
        //判断是否为空
        if(isEmpty()) throw new RuntimeException("队列空，不能取数据");

        //先把front对应的值保存到一个临时变量
        //将front后移(考虑取模)，将临时保存的变量返回
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQuene(){
        //遍历
        if(isEmpty()) {
            System.out.println("队列空，无数据");
            return;
        }
        //从front开始遍历，
        for (int i = front; i <front+size(); i++) {
            System.out.printf("arr[%d] = %d \n",i % maxSize ,arr[i % maxSize]);
        }
    }

    //求出当前有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的对头数据
    public int headQunen(){
        if(isEmpty()) throw new RuntimeException("无数据");
        return arr[front % maxSize];//front指针未改变位置，只是返回该位置上的值
    }
}
