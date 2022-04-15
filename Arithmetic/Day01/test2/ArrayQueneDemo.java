package Day01.test2;


/**
 * ********概述：
 */
public class ArrayQueneDemo {
    public static void main(String[] args) {

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

}



