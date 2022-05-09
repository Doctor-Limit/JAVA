package Day02.test7;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * ********概述：马踏棋盘算法及其贪心算法优化
 * 优化方法：
 * 需要对ps中所有的point的下一步的所有集合的数目，进行非递减排序
 *
 */
public class HorseChessboard {

    private static int X;// 表示列数
    private static int Y;// 表示行数
    private static boolean[] visited;// 标记各个位置
    private static boolean finished;// 如果为true表示成功走完

    public static void main(String[] args) {
        System.out.println("马踏棋盘算法运行中:");
        X = 8;
        Y = 8;
        int row = 1;// 马儿初始位置的行，从一开始
        int column = 1;// 马儿的初始位置的列，从一开始

        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];// 初始为false

        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();

        System.out.println("共耗时:" + (end - start)+ "ms");

        // 输出棋盘的情况
        for (int[] rows :chessboard) {
            for (int step :rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     *    马踏棋盘算法
     * @param chessboard  棋盘
     * @param row         表示马儿当前位置的行，从0开始
     * @param column      表示马儿当前位置的列，从0开始
     * @param step        表示当前是马儿走的是第几步，初始从1开始
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        //表示在棋盘上是第几个元素，左上角为1，当前行数*总列数+当前列数即为第多少个元素，数组索引从0开始
        visited[row * X + column] = true;// 标记为已访问
        // 获取当前位置可以走的位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        // 对ps进行排序,对ps所有Point对象下一步的数目进行非递减排序
        sort(ps);
        // 遍历ps
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);// 取出一个可以走的位置作为下一个位置
            // 判断该点是否已访问
            if (!visited[p.y * X + p.x]) {// 说明未访问过
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }
        // 判断马儿是否走完棋盘所有位置，step与应该走的步数比较，未达到数量就说明未完成任务，后将整个棋盘置0
        // step < x * y成立时满足以下其中一种
        // 1、棋盘到目前为止仍为走完
        // 2、棋盘处于回溯过程
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    /**
     *        根据当前位置计算马儿可以走的位置
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
       ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        // 能够走左移两列上移一行对应的该点
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 能够走左移两列下移一行对应的该点
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 能够走右移两列上移一行对应的该点
        if ((p1.x = curPoint.x + 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 能够走右移两列下移一行对应的该点
        if ((p1.x = curPoint.x + 2) >= 0 && (p1.y = curPoint.y + 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 能够走左移一列上移两行对应的该点
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        // 能够走左移一列下移两行对应的该点
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) >= 0) {
            ps.add(new Point(p1));
        }
        // 能够走右移一列上移两行对应的该点
        if ((p1.x = curPoint.x + 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        // 能够走右移一列下移两行对应的该点
        if ((p1.x = curPoint.x + 1) >= 0 && (p1.y = curPoint.y + 2) >= 0) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    // 根据当前这一步的所有下一步的选择位置，进行非递减排序,减少回溯的次数
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                // 获取到o1点的下一步的所有位置个数
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                } else if (count1 > count2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

}
