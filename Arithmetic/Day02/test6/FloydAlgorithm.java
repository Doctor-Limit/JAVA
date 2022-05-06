package Day02.test6;

import java.util.Arrays;

/**
 * ********概述：弗洛伊德算法实现最小生成树
 */
public class FloydAlgorithm {
    public static void main(String[] args) {

    }
}

class Graph1 {
    private char[] vertex;// 存放顶点数组
    private int[][] dis;// 保存从各个顶点出发到其他顶点的距离
    private int[][] pre;// 保存各个结点的前驱结点

    /**
     *
     * @param length  大小
     * @param matrix  邻接矩阵
     * @param vertex   顶点数组
     */
    public Graph1 (int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        // 对pre数组初始化，存放的是前驱结点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    // 显示pre数组及dis数组
    public void show() {
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(pre[k][i] + " ");
            }
            System.out.println();

            // 输出dis数组
            for (int i = 0; i < dis.length; i++) {
                System.out.print(dis[k][i] + " ");
            }
            System.out.println();
        }
    }



}
