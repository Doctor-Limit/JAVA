package Day02.test2;

/**
 * ********概述：分治算法解决汉罗塔问题
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B','C');
    }

    //汉诺塔的移动问题
    /**
     *
     * @param num 盘的个数
     * @param a   a塔 :起始塔
     * @param b   b塔 :过程塔
     * @param c   c塔 :终点塔
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        // 如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            // 在n >= 2的情况下，可把总体视为两个盘，最下面的一个盘1，以及其他所有盘2
            // 1、先把盘2从A->B,中间会使用到c，但起始为a塔终点为b塔
            hanoiTower(num - 1, a, c, b);
            // 2、将盘1从A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            // 3、将盘2从B->C
            hanoiTower(num - 1, b, a, c);
        }
    }

}
