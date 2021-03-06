package Day01.test2;

import java.util.Scanner;

import static Day01.test2.ArrayQueen.menu;

/**
 * ********概述：数组实现一次性队列
 */
public class ArrayQueneDemo {

    public static void main(String[] args) {
        ArrayQueen queen = new ArrayQueen(3);
        char key=' ';//供用户输入
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            menu();
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
                    System.out.println("输入有误，请重新输入：");
                    break;
            }
        }
        System.out.println("程序退出~~~");
    }
}

class ArrayQueen {

    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueen(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;//指向队列尾，指向队列尾的数据（即为队列的最后一个数据）
    }

    //菜单项
    public static void menu(){
        System.out.println("s(show):显示队列");
        System.out.println("e(exit):退出程序");
        System.out.println("a(add):添加数据到到队列");
        System.out.println("g(get):从队列中取出数据");
        System.out.println("h(head):查看队列头的数据");
    }

    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQuene(int n){
        //判断是否已满
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear]=n;
    }

    //获取队列的数据，出队列
    public int getQueen(){
        //判断是否为空
        if(isEmpty()) throw new RuntimeException("队列空，不能取数据");
        front++;
        return arr[front];//front指针改变位置，向后移一位代表取出一位
    }

    //显示队列所有数据
    public void showQuene(){
        //遍历
        if(isEmpty()) {
            System.out.println("队列空，无数据");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的对头数据
    public int headQunen(){
        if(isEmpty()) throw new RuntimeException("无数据");
        return arr[front+1];//front指针未改变位置，只是返回该位置上的值
    }
}



