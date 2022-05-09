package Day02.test6;

import java.util.Arrays;

/**
 * ********概述：弗洛伊德算法实现最小生成树
 */
public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix = new int[][] {
                {0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N, N, 8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0}
        };
        Graph1 graph = new Graph1(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();

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
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();

            // 输出dis数组
            for (int i = 0; i < dis.length; i++) {
                System.out.print("("+vertex[k]+"到"+vertex[i]+"的最短路径是"+dis[k][i] + ")");
            }
            System.out.println();
        }
    }

    // 弗洛伊德算法
    public void floyd() {
        int len = 0;// 保存顶点距离
        // 从中间顶点遍历，k就是中间顶点的下标，例如A为中间结点，就有GAB，GAC等
        for (int k = 0; k < dis.length; k++) {
            // 从i顶点开始出发，{'A', 'B', 'C', 'D', 'E', 'F', 'G'}，
            for (int i = 0; i < dis.length; i++) {
                // 到达j顶点
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];// 求出从i顶点出发，经过k中间顶点，到达j顶点距离
                    if (len < dis[i][j]) {// 如果len小于两者直连距离，就会更新
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];// 更新前驱结点
                    }
                }
            }
        }
    }


}
