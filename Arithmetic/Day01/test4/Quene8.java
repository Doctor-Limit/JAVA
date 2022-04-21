package Day01.test4;

/**
 * ********概述：
 */
public class Quene8 {

    // 确定皇后的个数
    int max = 8;

    // 定义数组保存皇后最后位置的结果
    int[] arr = new int[max];
    static int count = 0;// 存放最多次数结果
    static int judgeCount = 0;// 判断冲突次数

    public static void main(String[] args) {
        Quene8 quene8 = new Quene8();
        quene8.check(0);
        System.out.printf("一共有%d种解法\n",count);
        System.out.printf("判断了%d次冲突",judgeCount);
    }

    // 编写一个方法，放置第n个皇后
    // check每次递归时，后进入到check中都有循环，因此会有回溯
    private void check(int n) {
        if(n == max) {// n=8时，8个皇后已经全部放好
            print(); // 此时会返回到上一次的结果并在此基础上回溯
            return;
        }

        // 依次放皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            judgeCount++;
            // 先把当前皇后n放到第一列
            arr[n] = i;
            // 当放置第n个皇后到第i列时，是否冲突
            if (judge(n)) { //不冲突
                // 放置第n+1个皇后，开始递归
                check(n+1);
            }
            // 如果冲突，就继续执行arr[n] = i;就会将此第n个皇后，放置到下一列
        }
    }

    // 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    // n表示第n个皇后,同时也代表行数，
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // arr[i] == arr[n]表示第n个皇后是否和前面的n-1个皇后在同一列
            //  Math.abs(n-i) == Math.abs(arr[n]-arr[i]) 表示第n个皇后是否和前面的n-1个皇后在同一斜线
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])) {
                return false;
            }
        }
        return true;
    }

    // 写一个方法,将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
